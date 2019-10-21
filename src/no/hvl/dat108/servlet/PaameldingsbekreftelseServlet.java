package no.hvl.dat108.servlet;

import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_LOGGAINN;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_TYPE_LOGGINNSIDE;
import static no.hvl.dat108.util.FeilmeldingUtil.settFeilmeldingSesjon;
import static no.hvl.dat108.util.LogginnUtil.erInnlogga;
import static no.hvl.dat108.util.URLListe.LOGGINN_URL;
import static no.hvl.dat108.util.URLListe.PAAMELDINGSBEKREFTELSE_JSP;
import static no.hvl.dat108.util.URLListe.PAAMELDINGSBEKREFTELSE_URL;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.eao.DeltakarEAO;
import no.hvl.dat108.entity.Deltakar;

/**
 * Paameldingsbekreftelse
 */
@WebServlet("/" + PAAMELDINGSBEKREFTELSE_URL)
public class PaameldingsbekreftelseServlet extends HttpServlet {

    @EJB
    private DeltakarEAO deltakarEAO;

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!erInnlogga(request)) {
            settFeilmeldingSesjon(request, FEIL_TYPE_LOGGINNSIDE, FEIL_LOGGAINN);
            //til logginn eller til skjema?
            response.sendRedirect(LOGGINN_URL);
        } else {

            //TODO litt usikker her...
            
            //hente frå sesjonen... eller kan ein hente ned igjen frå databasen
            //Deltakar d = (Deltakar) request.getSession().getAttribute("deltakar");

            //TODO exception ved databasefeil?
            Deltakar d = deltakarEAO.hentBrukar((String)request.getAttribute("mobilnr"));
            //request.getSession().removeAttribute("deltakar");
            request.setAttribute("deltakar", d);

            request.getRequestDispatcher(PAAMELDINGSBEKREFTELSE_JSP).forward(request, response); 
        }
    }

    
}