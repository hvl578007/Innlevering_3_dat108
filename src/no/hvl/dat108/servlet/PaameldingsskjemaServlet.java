﻿package no.hvl.dat108.servlet;

import static no.hvl.dat108.util.LogginnUtil.logginn;
import static no.hvl.dat108.util.URLListe.PAAMELDINGSBEKREFTELSE_URL;
import static no.hvl.dat108.util.URLListe.PAAMELDINGSSKJEMA_JSP;
import static no.hvl.dat108.util.URLListe.PAAMELDINGSSKJEMA_URL;
import static no.hvl.dat108.util.ValideringUtil.erGyldigSkjemaInput;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.eao.DeltakarEAO;
import no.hvl.dat108.entity.Deltakar;
import no.hvl.dat108.util.FeilmeldingUtil;
import no.hvl.dat108.util.Hashing;
import no.hvl.dat108.util.SkjemaInfo;

/**
 * Paameldingsskjema
 */
@WebServlet("/" + PAAMELDINGSSKJEMA_URL)
public class PaameldingsskjemaServlet extends HttpServlet {

    @EJB
    private DeltakarEAO deltakarEAO;
    
    private int sesjonsTid;

    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        try {
            sesjonsTid = Integer.parseInt(getServletContext().getInitParameter("sesjonstid"));
        } catch (NumberFormatException e) {
            sesjonsTid = 60;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // kan hente ut skjemaInfo objektet og setje det på request og så slette det frå
        // sesjonen...
        // men den vil uansett forsvinne då ein resetter sesjonen ved gyldig
        // skjema/logginn

        request.getRequestDispatcher(PAAMELDINGSSKJEMA_JSP).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().removeAttribute("skjemaInfo");

        String fornamn = request.getParameter("fornamn");
        String etternamn = request.getParameter("etternamn");
        String mobilnr = request.getParameter("mobilnr");
        String passord = request.getParameter("passord");
        String passordRepetert = request.getParameter("passordRepetert");
        String kjoenn = request.getParameter("kjoenn");

        SkjemaInfo skjemaInfo = new SkjemaInfo(fornamn, etternamn, mobilnr, passord, passordRepetert, kjoenn);

        // må sjekke om kvar ting var ok eller ikkje, og så setje evt feilmeldingar

        if (erGyldigSkjemaInput(skjemaInfo, deltakarEAO)) {

            Hashing hashing = new Hashing(Hashing.SHA256);

            // "sanitisere" data her??? eller er det nok med god validering?

            byte[] salt = hashing.getSalt();

            try {
                hashing.generateHashWithSalt(passord, salt);
            } catch (NoSuchAlgorithmException e) {}
            
            Deltakar d = new Deltakar(fornamn, etternamn, mobilnr, hashing.getPasswordHashinHex(), hashing.getPasswordSalt(), kjoenn);

            // alt godkjent -> lagre i databasen

            try {
                deltakarEAO.leggTilDeltakar(d);
            } catch (Exception e) {
                FeilmeldingUtil.settFeilmeldingSesjon(request, FeilmeldingUtil.FEIL_TYPE_DATABASE, FeilmeldingUtil.FEIL_DATABASE);
                response.sendRedirect(PAAMELDINGSSKJEMA_URL);
            }

            // legg til deltakar i sesjonen? - kan enkelt hente ut og lise i bekreftelsen
            // då!
            //request.getSession().setAttribute("deltakar", d);
            //evt hentar ut i bekreftelse frå databasen... idk?

            logginn(request, sesjonsTid, mobilnr);

            response.sendRedirect(PAAMELDINGSBEKREFTELSE_URL);

        } else {
            HttpSession sesjon = request.getSession();

            sesjon.setAttribute("skjemaInfo", skjemaInfo);

            response.sendRedirect(PAAMELDINGSSKJEMA_URL);
        }

    }
}