package no.hvl.dat108.servlet;

import static no.hvl.dat108.util.LogginnUtil.loggut;
import static no.hvl.dat108.util.URLListe.LOGGUT_URL;
import static no.hvl.dat108.util.URLListe.UTLOGGA_HTML;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Loggut
 */
@WebServlet("/" + LOGGUT_URL)
public class LoggutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        loggut(request);

        response.sendRedirect(UTLOGGA_HTML);
    }

    
}