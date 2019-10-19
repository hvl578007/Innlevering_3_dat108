package no.hvl.dat108.util;

/**
 * ValideringUtil
 * 
 * Dette er enkel validering på om brukarinput er gyldig og slikt, ikkje om det er rett innloggingsinfo etc.
 */
public class ValideringUtil {

    //statiske? evt lage objekt og bruke dei som objekt-metodar

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
        String regex = "^\\p{javaUpperCase}[\\p{IsAlphabetic}\\p{Blank}-]+$";
        
        if(fornamn != null && !fornamn.isEmpty() && fornamn.length() >= 2 && fornamn.length() <= 20) { 

            return fornamn.matches(regex);

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
            
            return etternamn.matches(regex);

        }
        return false;
    }

    public static boolean erGyldigMobilnummer(String mobilnr) {

        if(mobilnr != null) {
            //knytte opp til database her?
            return mobilnr.length() == 8;
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
}