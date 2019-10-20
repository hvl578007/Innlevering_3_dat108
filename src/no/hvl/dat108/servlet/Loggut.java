package no.hvl.dat108.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static no.hvl.dat108.util.URLListe.*;
import static no.hvl.dat108.util.LogginnUtil.*;

/**
 * Loggut
 */
@WebServlet("/" + LOGGUT_URL)
public class Loggut extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //skal kanskje ikkje ha post?
        loggut(request);
        
        request.getRequestDispatcher(LOGGUT_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    
}