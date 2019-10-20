package no.hvl.dat108.util;

import javax.servlet.http.HttpServletRequest;

/**
 * FeilmeldingUtil
 */
public class FeilmeldingUtil {

    public static final String FEIL_BRUKARNAMN_PASSORD = "Ugyldig brukarnamn og/eller passord";
    public static final String FEIL_FORNAMN = "Ugyldig fornamn";
    public static final String FEIL_ETTERNAMN = "Ugyldig etternamn";
    public static final String FEIL_MOBILNR = "Ugyldig mobilnummer";
    public static final String FEIL_PASSORD = "Ugyldig passord";
    public static final String FEIL_PASSORD_REP = "Passorda må være like";
    public static final String FEIL_KJOENN = "Du må oppgi kjønn";
    public static final String FEIL_LOGGAINN = "Du må vere logga inn for å sjå denne sida";

    public static final String FEIL_TYPE_LOGGINNSIDE = "feilLogginnSide";
    public static final String FEIL_TYPE_FN = "feilFornamn";
    public static final String FEIL_TYPE_EN = "feilEtternamn";
    public static final String FEIL_TYPE_MOB = "feilMobilnr";
    public static final String FEIL_TYPE_PASS = "feilPassord";
    public static final String FEIL_TYPE_PASSREP = "feilPassordRep";
    public static final String FEIL_TYPE_KJOENN = "feilKjoenn";

    /**
     * Hentar feilmelding og slettar den frå sesjonen (for at den ikkje blir liggande der)
     * @param request
     * @param feilmeldingType den typen feilmelding som skal hentast
     * @return feilmeldingen
     */
    public static String hentFeilmelding(HttpServletRequest request, String feilmeldingType) {
        String feilmelding = (String)request.getSession().getAttribute(feilmeldingType);
        request.getSession().removeAttribute(feilmeldingType);
        return feilmelding;
    }

    /**
     * Sett feilmelding på sesjonen - bruke for å sende til ein servlet etter redirect ++
     * @param request
     * @param feilmeldingType typen feilmelding
     * @param feilmelding feilmeldingsteksten
     */
    public static void settFeilmeldingSesjon(HttpServletRequest request, String feilmeldingType, String feilmelding) {
        if (feilmelding != null) {
            request.getSession().setAttribute(feilmeldingType, feilmelding);
        }
    }

    /**
     * Sett feilmelding på request - bruke for å sende til jsp
     * @param request
     * @param feilmeldingType typen feilmelding
     * @param feilmelding feilmeldingsteksten
     */
    public static void settFeilmeldingRequest(HttpServletRequest request, String feilmeldingType, String feilmelding) {
        if (feilmelding != null) {
            request.setAttribute(feilmeldingType, feilmelding);
        }
    }
}