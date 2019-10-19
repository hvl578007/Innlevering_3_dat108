package no.hvl.dat108.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static no.hvl.dat108.util.URLListe.*;


/**
 * Deltakarliste
 */
@WebServlet("/" + DELTAKARLISTE_URL)
public class Deltakarliste extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    
}