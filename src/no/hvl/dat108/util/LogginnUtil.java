package no.hvl.dat108.util;

import static no.hvl.dat108.util.ValideringUtil.erGyldigMobilnummer;
import static no.hvl.dat108.util.ValideringUtil.erGyldigPassord;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.eao.DeltakarEAO;
import no.hvl.dat108.entity.Deltakar;

/**
 * LogginnUtil
 */
public class LogginnUtil {

    public static boolean erGyldigLegitimasjon(HttpServletRequest request, DeltakarEAO deltakarEAO) {

        String mobilnr = request.getParameter("mobil");
        String passord = request.getParameter("passord");

        //sjekkar om dei er gyldige først, så slepp ein å hashe/hente ned info frå server uansett
        if(erGyldigMobilnummer(mobilnr) && erGyldigPassord(passord)) {

            //TODO 
            
            //"sanitisere" mobilnr og passord !?!?
            //...

            //hent ned brukarobjekt
            Deltakar d = deltakarEAO.hentBrukar(mobilnr);
            //kanskje betre å hente brukaren i servlet, kan enkelt teste denne då

            if (d != null) {
                //long salt = d.getPassordsalt();

                //hash passord - eigen metode, kanskje i eigen util..

                //sjekk passord -> er likt -> return true
                return true;
            }
        }

        return false;
    }

    public static boolean erInnlogga(HttpServletRequest request) {

        //noko anna for å "vise" at ein er innlogga???
        //mobilnummer? må hente ned brukaren...
        return request.getSession().getAttribute("innlogga") != null;
    }

    public static void logginn(HttpServletRequest request, int sesjonTid) {
        loggut(request);
        HttpSession sesjon = request.getSession();

        //bruke noko anna for å "vise" at ein er innlogga?
        sesjon.setAttribute("innlogga", "ER_INNLOGGA");
        
        sesjon.setMaxInactiveInterval(sesjonTid);
    }

    public static void loggut(HttpServletRequest request) {
        HttpSession sesjon = request.getSession(false);
        if (sesjon != null) {
            sesjon.invalidate();
        }
    }
}