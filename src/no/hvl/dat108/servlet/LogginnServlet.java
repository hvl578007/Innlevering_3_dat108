package no.hvl.dat108.servlet;

import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_BRUKARNAMN_PASSORD;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_TYPE_LOGGINNSIDE;
import static no.hvl.dat108.util.FeilmeldingUtil.hentFeilmelding;
import static no.hvl.dat108.util.FeilmeldingUtil.settFeilmeldingRequest;
import static no.hvl.dat108.util.FeilmeldingUtil.settFeilmeldingSesjon;
import static no.hvl.dat108.util.LogginnUtil.erGyldigLegitimasjon;
import static no.hvl.dat108.util.LogginnUtil.logginn;
import static no.hvl.dat108.util.URLListe.DELTAKARLISTE_URL;
import static no.hvl.dat108.util.URLListe.LOGGINN_JSP;
import static no.hvl.dat108.util.URLListe.LOGGINN_URL;

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
            String mobilnr = request.getParameter("mobilnr");

            logginn(request, sesjonsTid, mobilnr);

            response.sendRedirect(DELTAKARLISTE_URL);
        }
    }
}