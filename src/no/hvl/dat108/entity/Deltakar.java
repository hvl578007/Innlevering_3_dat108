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
    private String mobilnummer; //??? evt int?

    private long passordhash; //??? anna format?
    private long passordsalt; //??? anna format?
    private String kjoenn;

    public Deltakar() {}

    public Deltakar(String fornamn, String etternamn, String mobilnummer, long passordhash, long passordsalt, String kjoenn) {
        this.fornamn = fornamn;
        this.etternamn = etternamn;
        this.mobilnummer = mobilnummer;
        this.passordhash = passordhash;
        this.passordsalt = passordsalt;
        this.kjoenn = kjoenn;
    }

    //midlertidig for å teste
    public Deltakar(String fornamn, String etternamn, String mobilnummer, String kjoenn) {
        this.fornamn = fornamn;
        this.etternamn = etternamn;
        this.mobilnummer = mobilnummer;
        this.passordhash = 0;
        this.passordsalt = 0;
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

    public long getPassordhash() {
        return passordhash;
    }

    public void setPassordhash(long passordhash) {
        this.passordhash = passordhash;
    }

    public long getPassordsalt() {
        return passordsalt;
    }

    public void setPassordsalt(long passordsalt) {
        this.passordsalt = passordsalt;
    }

    public String getkjoenn() {
        return kjoenn;
    }

    public void setkjoenn(String kjoenn) {
        this.kjoenn = kjoenn;
    }
    
}