package no.hvl.dat108.servlet;

import static no.hvl.dat108.util.URLListe.DELTAKARLISTE_URL;
import static no.hvl.dat108.util.URLListe.LOGGINN_JSP;
import static no.hvl.dat108.util.URLListe.LOGGINN_URL;
import static no.hvl.dat108.util.LogginnUtil.*;
import static no.hvl.dat108.util.FeilmeldingUtil.*;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.eao.DeltakarEAO;

/**
 * Logginn
 */
@WebServlet("/" + LOGGINN_URL)
public class LogginnServlet extends HttpServlet {

    @EJB
    private DeltakarEAO deltakarEAO;

    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Hent feilmelding
        String feilmelding = hentFeilmelding(request, FEIL_TYPE_LOGGINNSIDE);

        //Sende med feilmelding til jsp-sida:
        settFeilmeldingRequest(request, FEIL_TYPE_LOGGINNSIDE, feilmelding);

        //Går til JSP-sida
        request.getRequestDispatcher(LOGGINN_JSP).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //skal ikkje sjekke om det er valid input her... berre om det var gyldig legitimasjon

        if(!erGyldigLegitimasjon(request, deltakarEAO)) {

            settFeilmeldingSesjon(request, FEIL_TYPE_LOGGINNSIDE, FEIL_BRUKARNAMN_PASSORD);
            response.sendRedirect(LOGGINN_URL);

        } else {
            String mobilnr = (String) request.getAttribute("mobilnr");
            //TODO må lagre i web.xml:
            int sesjonTid = 60;
            logginn(request, sesjonTid, mobilnr);

            response.sendRedirect(DELTAKARLISTE_URL);
        }
    }
}