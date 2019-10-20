package no.hvl.dat108.servlet;

import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_TYPE_EN;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_TYPE_FN;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_TYPE_KJOENN;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_TYPE_MOB;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_TYPE_PASS;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_TYPE_PASSREP;
import static no.hvl.dat108.util.FeilmeldingUtil.hentFeilmelding;
import static no.hvl.dat108.util.FeilmeldingUtil.settFeilmeldingRequest;
import static no.hvl.dat108.util.URLListe.PAAMELDINGSSKJEMA_JSP;
import static no.hvl.dat108.util.URLListe.PAAMELDINGSSKJEMA_URL;
import static no.hvl.dat108.util.URLListe.PAAMELDINGSBEKREFTELSE_URL;
import static no.hvl.dat108.util.ValideringUtil.erGyldigSkjemaInput;
import static no.hvl.dat108.util.LogginnUtil.*;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.eao.DeltakarEAO;
import no.hvl.dat108.entity.Deltakar;

/**
 * Paameldingsskjema
 */
@WebServlet("/" + PAAMELDINGSSKJEMA_URL)
public class Paameldingsskjema extends HttpServlet {

    @EJB
    private DeltakarEAO deltakarEAO;

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //hentar og sett feilmeldingar (om det er nokon, null-sjekkar blir gjort i metodane)
        //evt gjere alt dette om til ein metode i FeilmeldingUtil?
        String feilFornamn = hentFeilmelding(request, FEIL_TYPE_FN);
        String feilEtternamn = hentFeilmelding(request, FEIL_TYPE_EN);
        String feilMobilnr = hentFeilmelding(request, FEIL_TYPE_MOB);
        String feilPassord = hentFeilmelding(request, FEIL_TYPE_PASS);
        String feilPassordRep = hentFeilmelding(request, FEIL_TYPE_PASSREP);
        String feilKjoenn = hentFeilmelding(request, FEIL_TYPE_KJOENN);
        
        settFeilmeldingRequest(request, FEIL_TYPE_FN, feilFornamn);
        settFeilmeldingRequest(request, FEIL_TYPE_EN, feilEtternamn);
        settFeilmeldingRequest(request, FEIL_TYPE_MOB, feilMobilnr);
        settFeilmeldingRequest(request, FEIL_TYPE_PASS, feilPassord);
        settFeilmeldingRequest(request, FEIL_TYPE_PASSREP, feilPassordRep);
        settFeilmeldingRequest(request, FEIL_TYPE_KJOENN, feilKjoenn);

        //sette typane også på request så ein kan bruke konstantane der?

        //må hente ut felt som var gyldige ??? - evt blir henta frå sesjonen som blir satt i POST?

        request.getRequestDispatcher(PAAMELDINGSSKJEMA_JSP).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fornamn = (String) request.getAttribute("fornamn");
        String etternamn = (String) request.getAttribute("etternamn");
        String mobilnr = (String) request.getAttribute("mobilnr");
        String passord = (String) request.getAttribute("passord");
        String passordRepetert = (String) request.getAttribute("passordRepetert");
        String kjoenn = (String) request.getAttribute("kjoenn");

        //må sjekke om kvar ting var ok eller ikkje, og så setje evt feilmeldingar

        if (erGyldigSkjemaInput(request, fornamn, etternamn, mobilnr, passord, passordRepetert, kjoenn)) {
            
            int sesjonTid = 60;
            logginn(request, sesjonTid);

            //TODO
            
            //må nok "sanitisere" data her!
            
            //må hashe passord før ein lagrar også

            Deltakar d = new Deltakar(fornamn, etternamn, mobilnr, kjoenn);
            //Deltakar d = new Deltakar(fornamn, etternamn, mobilnr, passordhash, passordsalt, kjoenn);

            //alt godkjent -> lagre i databasen

            //deltakarEAO.leggTilDeltakar(d);

            //legg til deltakar i sesjonen? - kan enkelt hente ut og lise i bekreftelsen då!
            request.getSession().setAttribute("deltakar", d);

            response.sendRedirect(PAAMELDINGSBEKREFTELSE_URL);
            
        } else {
            HttpSession sesjon = request.getSession();
            sesjon.setAttribute("fornamn", fornamn);
            sesjon.setAttribute("etternamn", etternamn);
            sesjon.setAttribute("mobilnr", mobilnr);
            sesjon.setAttribute("passord", passord);
            sesjon.setAttribute("passordRepetert", passordRepetert);
            //sesjon.setAttribute("kjoenn", kjoenn);

            response.sendRedirect(PAAMELDINGSSKJEMA_URL);
        }
        

    }
}