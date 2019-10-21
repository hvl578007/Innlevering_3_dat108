package no.hvl.dat108.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Deltakar
 */
@Entity
@Table(schema = "dat108_oblig3", name = "deltakar")
public class Deltakar {

    private String fornamn;
    private String etternamn;

    @Id
    private String mobilnummer;

    private String passordhash;
    private String passordsalt;
    private String kjoenn; // evt char

    public Deltakar() {
    }

    public Deltakar(String fornamn, String etternamn, String mobilnummer, String passordhash, String passordsalt,
            String kjoenn) {
        this.fornamn = fornamn;
        this.etternamn = etternamn;
        this.mobilnummer = mobilnummer;
        this.passordhash = passordhash;
        this.passordsalt = passordsalt;
        this.kjoenn = kjoenn;
    }

    // midlertidig for å teste
    public Deltakar(String fornamn, String etternamn, String mobilnummer, String kjoenn) {
        this.fornamn = fornamn;
        this.etternamn = etternamn;
        this.mobilnummer = mobilnummer;
        this.passordhash = "";
        this.passordsalt = "";
        this.kjoenn = kjoenn;
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

    public String getMobilnummer() {
        return mobilnummer;
    }

    public void setMobilnummer(String mobilnummer) {
        this.mobilnummer = mobilnummer;
    }

    public String getPassordhash() {
        return passordhash;
    }

    public void setPassordhash(String passordhash) {
        this.passordhash = passordhash;
    }

    public String getPassordsalt() {
        return passordsalt;
    }

    public void setPassordsalt(String passordsalt) {
        this.passordsalt = passordsalt;
    }

    public String getKjoenn() {
        return kjoenn;
    }

    public void setKjoenn(String kjoenn) {
        this.kjoenn = kjoenn;
    }

    public String getMobilnrFormatert() {
        return String.format("%s %s %s", mobilnummer.substring(0, 3), mobilnummer.substring(3, 5),
                mobilnummer.substring(5));
    }

    public String getKjoennFormatert() {
        if (kjoenn != null && kjoenn.equals("mann")) {
            return "&#9794;";
        } else if (kjoenn != null && kjoenn.equals("kvinne")) {
            return "&#9792;";
        }
        return null;
    }

}