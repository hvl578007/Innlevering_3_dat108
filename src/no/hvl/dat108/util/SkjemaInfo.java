package no.hvl.dat108.util;

/**
 * SkjemaInfo
 */
public class SkjemaInfo {

    private String fornamn;
    private String etternamn;
    private String mobilnr;
    private String passord;
    private String passordRep;
    private String kjoenn;

    private String fornamnFeil;
    private String etternamnFeil;
    private String mobilFeil;
    private String passordFeil;
    private String passordRepFeil;
    private String kjoennFeil;

    public SkjemaInfo() {};

    public SkjemaInfo(String fornamn, String etternamn, String mobilnr, String passord, String passordRep,
            String kjoenn) {
        this.fornamn = fornamn;
        this.etternamn = etternamn;
        this.mobilnr = mobilnr;
        this.passord = passord;
        this.passordRep = passordRep;
        this.kjoenn = kjoenn;
    }

    public SkjemaInfo(String fornamn, String etternamn, String mobilnr, String passord, String passordRep,
            String kjoenn, String fornamnFeil, String etternamnFeil, String mobilFeil, String passordFeil,
            String passordRepFeil, String kjoennFeil) {
        this.fornamn = fornamn;
        this.etternamn = etternamn;
        this.mobilnr = mobilnr;
        this.passord = passord;
        this.passordRep = passordRep;
        this.kjoenn = kjoenn;
        this.fornamnFeil = fornamnFeil;
        this.etternamnFeil = etternamnFeil;
        this.mobilFeil = mobilFeil;
        this.passordFeil = passordFeil;
        this.passordRepFeil = passordRepFeil;
        this.kjoennFeil = kjoennFeil;
    }

    public String getFornamn() {
        return fornamn;
    }

    public void setFornamn(String fornamn) {
        this.fornamn = fornamn;
    }

    public String getEtternamn() {
        return etternamn;
    }

    public void setEtternamn(String etternamn) {
        this.etternamn = etternamn;
    }

    public String getMobilnr() {
        return mobilnr;
    }

    public void setMobilnr(String mobilnr) {
        this.mobilnr = mobilnr;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getPassordRep() {
        return passordRep;
    }

    public void setPassordRep(String passordRep) {
        this.passordRep = passordRep;
    }

    public String getKjoenn() {
        return kjoenn;
    }

    public void setKjoenn(String kjoenn) {
        this.kjoenn = kjoenn;
    }

    public String getFornamnFeil() {
        return fornamnFeil;
    }

    public void setFornamnFeil(String fornamnFeil) {
        this.fornamnFeil = fornamnFeil;
    }

    public String getEtternamnFeil() {
        return etternamnFeil;
    }

    public void setEtternamnFeil(String etternamnFeil) {
        this.etternamnFeil = etternamnFeil;
    }

    public String getMobilFeil() {
        return mobilFeil;
    }

    public void setMobilFeil(String mobilFeil) {
        this.mobilFeil = mobilFeil;
    }

    public String getPassordFeil() {
        return passordFeil;
    }

    public void setPassordFeil(String passordFeil) {
        this.passordFeil = passordFeil;
    }

    public String getPassordRepFeil() {
        return passordRepFeil;
    }

    public void setPassordRepFeil(String passordRepFeil) {
        this.passordRepFeil = passordRepFeil;
    }

    public String getKjoennFeil() {
        return kjoennFeil;
    }

    public void setKjoennFeil(String kjoennFeil) {
        this.kjoennFeil = kjoennFeil;
    } 
    
}