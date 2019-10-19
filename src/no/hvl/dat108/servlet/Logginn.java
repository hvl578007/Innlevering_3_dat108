package no.hvl.dat108.servlet;

import static no.hvl.dat108.util.URLListe.DELTAKARLISTE_URL;
import static no.hvl.dat108.util.URLListe.LOGGINN_JSP;
import static no.hvl.dat108.util.URLListe.LOGGINN_URL;
import static no.hvl.dat108.util.LogginnUtil.*;

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
public class Logginn extends HttpServlet {

    @EJB
    private DeltakarEAO deltakarEAO;

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Hent feilmelding
        String feilmelding = (String)request.getSession().getAttribute("feilmelding");

        //Sende med feilmelding til jsp-sida:
        if(feilmelding != null) {
            request.setAttribute("feilmelding", feilmelding);
            request.getSession().removeAttribute("feilmelding");
        }

        //Går til JSP-sida
        request.getRequestDispatcher(LOGGINN_JSP).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //sjekk input...!? evt berre javascript

        if(!erGyldigLegitimasjon(request, deltakarEAO)) {

            request.getSession().setAttribute("feilmelding", "Feil brukarnamn / passord"); //byttast ut med "konstante" feilmelding-strenger!?!
            response.sendRedirect(LOGGINN_URL);

        } else {
            //...

            response.sendRedirect(DELTAKARLISTE_URL);
        }
    }
}