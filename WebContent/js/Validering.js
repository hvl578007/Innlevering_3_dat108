"use strict;"

class Validering {

    static erRettFornamn(fornamn = "") {
        // sjekker om første boksta er stor, og at lengda er rett
        return fornamn.charAt(0) === fornamn.charAt(0).toUpperCase() && fornamn.length >= 2 && fornamn.length <= 20;
    }
    
    static erRettEtternamn(etternamn = "") {
        // sjekker om første boksta er stor, og at lengda er rett
        return etternamn.charAt(0) === etternamn.charAt(0).toUpperCase() && etternamn.length >= 2 && etternamn.length <= 20;
    }
    
    static erRettMobilnr(mobilnr = "") {
        return mobilnr.length === 8
    }
    
    static erRettPassord(passord = "") {
        return passord.length >= 8;
    }
    
    static erRettPassordRep(passord = "", passordRep = "") {
        return passord === passordRep;
    }

    static erAlleRette(fornamn = "", etternamn = "", mobilnr = "", passord = "", passordRep = "") {
        return this.erRettFornamn(fornamn) && this.erRettEtternamn(etternamn) && this.erRettMobilnr(mobilnr) && this.erRettPassord(passord) && this.erRettPassordRep(passord, passordRep);
    }

    //lage generelle sjekk-funksjonar her? - burde kanskje ligga i DeltakarValidering... men det fungerer nå ...
    static sjekk(erRettFunksjon, inputfelt) {
        if (erRettFunksjon()) {
            inputfelt.setAttribute("style", "border-color: green");
        } else {
            inputfelt.setAttribute("style", "border-color: red");
        }
    }
}