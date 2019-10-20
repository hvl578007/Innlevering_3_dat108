package no.hvl.dat108.servlet;

import static no.hvl.dat108.util.LogginnUtil.erInnlogga;
import static no.hvl.dat108.util.URLListe.*;
import static no.hvl.dat108.util.FeilmeldingUtil.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.entity.Deltakar;

/**
 * Paameldingsbekreftelse
 */
@WebServlet("/" + PAAMELDINGSBEKREFTELSE_URL)
public class Paameldingsbekreftelse extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!erInnlogga(request)) {
            settFeilmeldingSesjon(request, FEIL_TYPE_LOGGINNSIDE, FEIL_LOGGAINN);
            //til logginn eller til skjema?
            response.sendRedirect(LOGGINN_URL);
        } else {
            
            Deltakar d = (Deltakar) request.getSession().getAttribute("deltakar");
            request.getSession().removeAttribute("deltakar"); //?
            request.getSession().setAttribute("mobilnr", d.getMobilnummer()); //???
            request.setAttribute("deltakar", d);

            request.getRequestDispatcher(PAAMELDINGSBEKREFTELSE_JSP).forward(request, response); 
        }
    }

    
}