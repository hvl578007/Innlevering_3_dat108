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
import no.hvl.dat108.util.FeilmeldingUtil;

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
            response.sendRedirect(LOGGINN_URL);
        } else {

            //litt usikker her...
            
            //hente frå sesjonen... eller kan ein hente ned igjen frå databasen <-- dette

            //hentar frå databasen
            String mobilnr = (String)request.getSession().getAttribute("mobilnr");

            Deltakar d = null;
            try {
                d = deltakarEAO.hentBrukar(mobilnr);
            } catch (Exception e) {
                settFeilmeldingSesjon(request, FeilmeldingUtil.FEIL_TYPE_DATABASE, FeilmeldingUtil.FEIL_DATABASE);
            }
            
            request.setAttribute("deltakar", d);

            request.getRequestDispatcher(PAAMELDINGSBEKREFTELSE_JSP).forward(request, response); 
        }
    }

    
}