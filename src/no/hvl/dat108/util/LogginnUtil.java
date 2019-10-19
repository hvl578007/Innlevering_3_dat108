package no.hvl.dat108.util;

import static no.hvl.dat108.util.ValideringUtil.erGyldigMobilnummer;
import static no.hvl.dat108.util.ValideringUtil.erGyldigPassord;

import javax.servlet.http.HttpServletRequest;

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

            //hent ned brukarobjekt
            Deltakar d = deltakarEAO.hentBrukar(mobilnr);
            //kanskje betre å hente brukaren i servlet, kan enkelt teste denne då

            long salt = d.getPassordsalt();

            //hash passord - eigen metode, kanskje i eigen util..

            //sjekk passord -> er likt -> return true

        }

        return false;
    }

    public void logginn(HttpServletRequest request) {

    }

    public void loggut(HttpServletRequest request) {

    }
}