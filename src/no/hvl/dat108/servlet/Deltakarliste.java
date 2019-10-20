package no.hvl.dat108.servlet;

import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_LOGGAINN;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_TYPE_LOGGINNSIDE;
import static no.hvl.dat108.util.FeilmeldingUtil.settFeilmeldingSesjon;
import static no.hvl.dat108.util.LogginnUtil.erInnlogga;
import static no.hvl.dat108.util.URLListe.DELTAKARLISTE_URL;
import static no.hvl.dat108.util.URLListe.LOGGINN_URL;
import static no.hvl.dat108.util.URLListe.DELTAKAR_JSP;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.eao.DeltakarEAO;
import no.hvl.dat108.entity.Deltakar;


/**
 * Deltakarliste
 */
@WebServlet("/" + DELTAKARLISTE_URL)
public class Deltakarliste extends HttpServlet {

    @EJB
    private DeltakarEAO deltakarEAO;

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        if (!erInnlogga(request)) {
            settFeilmeldingSesjon(request, FEIL_TYPE_LOGGINNSIDE, FEIL_LOGGAINN);
            response.sendRedirect(LOGGINN_URL);

        } else {

            String mobilnr = (String)request.getSession().getAttribute("mobilnr");

            Deltakar d = deltakarEAO.hentBrukar(mobilnr);

            //hentar lista av deltakarar
            List<Deltakar> liste = deltakarEAO.hentListe();

            liste.remove(d);

            //leggje sorteringa i EAO?
            liste.sort( (d1, d2) -> {
                if(d1.getFornamn().equals(d2.getFornamn())) {
                    return d1.getEtternamn().compareTo(d2.getEtternamn());
                } else {
                    return d1.getFornamn().compareTo(d2.getFornamn());
                }
            });

            //set den i requesten for å hente på jsp-sida
            request.setAttribute("deltakar", d);
            request.setAttribute("liste", liste);

            request.getRequestDispatcher(DELTAKAR_JSP).forward(request, response);
        }

    }

    
}