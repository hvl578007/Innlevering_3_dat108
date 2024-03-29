﻿package no.hvl.dat108.util;

import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_ETTERNAMN;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_FORNAMN;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_KJOENN;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_MOBILNR;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_PASSORD;
import static no.hvl.dat108.util.FeilmeldingUtil.FEIL_PASSORD_REP;

import javax.servlet.http.HttpServletRequest;

import no.hvl.dat108.eao.DeltakarEAO;

/**
 * ValideringUtil
 * 
 * Dette er enkel validering på om brukarinput er gyldig og slikt, ikkje om det
 * er rett innloggingsinfo etc.
 */
public class ValideringUtil {

    //statiske? evt lage objekt og bruke dei som objekt-metodar

    public static boolean erGyldigSkjemaInput(SkjemaInfo skjemaInfo, DeltakarEAO deltakarEAO) {
        boolean altGyldig = true;

        if (!erGyldigFornamn(skjemaInfo.getFornamn())) {
            skjemaInfo.setFornamn(null);
            skjemaInfo.setFornamnFeil(FEIL_FORNAMN);
            altGyldig = false;
        }
        
        if (!erGyldigEtternamn(skjemaInfo.getEtternamn())) {
            skjemaInfo.setEtternamn(null);
            skjemaInfo.setEtternamnFeil(FEIL_ETTERNAMN);
            altGyldig = false;
        }
        
        if (!erGyldigMobilnummer(skjemaInfo.getMobilnr())) {
            skjemaInfo.setMobilnr(null);
            skjemaInfo.setMobilFeil(FEIL_MOBILNR);
            altGyldig = false;
        }
        
        if (!erGyldigPassord(skjemaInfo.getPassord())) {
            skjemaInfo.setPassord(null);
            skjemaInfo.setPassordFeil(FEIL_PASSORD);
            altGyldig = false;
        }
        
        if (!erGyldigPassordRepetert(skjemaInfo.getPassord(), skjemaInfo.getPassordRep())) {
            skjemaInfo.setPassordRep(null);
            skjemaInfo.setPassordRepFeil(FEIL_PASSORD_REP);
            altGyldig = false;
        }

        if (!erGyldigKjoenn(skjemaInfo.getKjoenn())) {
            skjemaInfo.setKjoenn(null);
            skjemaInfo.setKjoennFeil(FEIL_KJOENN);
            altGyldig = false;
        }

        //gjer slik at ein får feil om mobilnr finst allereie
        if(altGyldig && deltakarEAO.erEksisterandeDeltakar(skjemaInfo.getMobilnr())) {
            skjemaInfo.setMobilnr(null);
            skjemaInfo.setMobilFeil(FEIL_MOBILNR);
            altGyldig = false;
        }

        return altGyldig;
    }

    public static boolean erGyldigFornamn(String fornamn) {
        
        //2-20 teikn, bokstavar, bindestrek og mellomrom, første må vere stor bokstav.
        //bruke regex
        /**
         * forklaring av regex:
         * \p{javaUpperCase} = første må vere ein stor bokstav, kunne nok også brukt IsUppercase
         * \p{IsAlphabetic} = det må vere ein boksav (inkluderar æøå, og sikkert andre då)
         * \p{Blank} = mellomrom (eller innrykk / tab)
         * [\p{IsAlphabetic}\p{Blank}-]+ = det må vere 1 eller meir av ein kombinasjon av bokstavar, bindestrek og mellomrom
         */
        String regex = "^\\p{javaUpperCase}[\\p{IsAlphabetic}\\p{Space}-]+$";
        
        if(fornamn != null && !fornamn.isEmpty() && fornamn.length() >= 2 && fornamn.length() <= 20) { 

            return fornamn.matches(regex) && !fornamn.matches("^.*--+.*$") && !fornamn.matches("^.*\\s\\s+.*$");

        }
        return false;
    }

    public static boolean erGyldigEtternamn(String etternamn) {

        /**
         * forklaring av regex:
         * \p{javaUpperCase} = første må vere ein stor bokstav, kunne nok også brukt IsUppercase, eller {Lu}
         * [\p{IsAlphabetic}-]+ = det må vere 1 eller meir av ein kombinasjon av bokstavar og bindestrek
         */
        String regex = "^\\p{javaUpperCase}[\\p{IsAlphabetic}-]+$";

        if (etternamn != null && !etternamn.isEmpty() && etternamn.length() >= 2 && etternamn.length() <= 20) {
            
            return etternamn.matches(regex) && !etternamn.matches("^.*--+.*$");

        }
        return false;
    }

    public static boolean erGyldigMobilnummer(String mobilnr) {

        if(mobilnr != null) {
            //knytte opp til database her?
            return mobilnr.length() == 8 && mobilnr.matches("^\\d+$");
        }
        return false;
    }

    public static boolean erGyldigPassord(String passord) {
        //kan endrast
        //leggje til regex f.eks?
        //må ha ein stor bokstav, liten bokstav og siffer!?
        if(passord != null && passord.length() >= 8 && passord.length() <= 20) {

            //fekk ikkje heilt til alt-i-ein-regex sidan ting kan komme kor som helst...
            //String regex = "^[\\p{javaUpperCase}\\p{javaLowerCase}\\d]+$";

            return passord.matches("^.*\\p{javaUpperCase}+.*$") && passord.matches("^.*\\p{javaLowerCase}+.*$") &&
                passord.matches("^.*\\d+.*$");
        }
        return false;
    }

    public static boolean erGyldigPassordRepetert(String passord, String passordRepetert) {
        return passord != null && passordRepetert != null && passord.equals(passordRepetert);
    }

    public static boolean erGyldigKjoenn(String kjoenn) {
        return kjoenn != null && (kjoenn.equals("mann") || kjoenn.equals("kvinne"));
    }
}