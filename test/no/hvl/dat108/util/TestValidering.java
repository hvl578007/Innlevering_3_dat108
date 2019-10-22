package no.hvl.dat108.util;

import static no.hvl.dat108.util.ValideringUtil.erGyldigEtternamn;
import static no.hvl.dat108.util.ValideringUtil.erGyldigFornamn;
import static no.hvl.dat108.util.ValideringUtil.erGyldigMobilnummer;
import static no.hvl.dat108.util.ValideringUtil.erGyldigPassord;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * TestValidering
 */
public class TestValidering {

    @Test
    public void testFornamnGyldige() {
        assertTrue(erGyldigFornamn("Stian"));
        assertTrue(erGyldigFornamn("Ådne"));
        assertTrue(erGyldigFornamn("Lars-Petter"));
        assertTrue(erGyldigFornamn("Rita Kristin"));
    }

    @Test
    public void testFornamnUgyldige() {
        assertFalse(erGyldigFornamn("stian"));
        assertFalse(erGyldigFornamn("H"));
        assertFalse(erGyldigFornamn("Litt For Langt Fornamn Dette"));
        assertFalse(erGyldigFornamn("Ikkje lov - 111"));
    }

    @Test
    public void testEtternamnGyldige() {
        assertTrue(erGyldigEtternamn("Grønås"));
        assertTrue(erGyldigEtternamn("Svendsen-Grønås"));
        assertTrue(erGyldigEtternamn("Ås"));
    }

    @Test
    public void testEtternamnUgyldige() {
        assertFalse(erGyldigEtternamn("grønås"));
        assertFalse(erGyldigEtternamn("Svendsen Grønås"));
        assertFalse(erGyldigEtternamn("VeldigLangtEtterNamnDetteAltså"));
        assertFalse(erGyldigEtternamn("IkkjeLovMed9Og-"));
    }

    @Test
    public void testMobilnummerGyldige() {
        assertTrue(erGyldigMobilnummer("98765432"));
        assertTrue(erGyldigMobilnummer("55566555"));
    }

    @Test
    public void testMobilnummerUgyldige() {
        assertFalse(erGyldigMobilnummer("A1234567"));
        assertFalse(erGyldigMobilnummer("1234567890"));
    }

    @Test
    public void testPassordGyldige() {
        assertTrue(erGyldigPassord("Super2019"));
        assertTrue(erGyldigPassord("Amnb982-p!?æå(10+]"));
        assertTrue(erGyldigPassord("øæÅm19-...**hei!"));
    }

    @Test
    public void testPassordUgyldige() {
        assertFalse(erGyldigPassord("manglerstor19"));
        assertFalse(erGyldigPassord("manglerTal"));
        assertFalse(erGyldigPassord("MANGLARLITEN1"));
        assertFalse(erGyldigPassord("Liten1"));
        assertFalse(erGyldigPassord("DenneErOgså..littforlang2019"));
    }

    @Test
    public void testBrukarValidering() {
        //TODO test validering!?
        //importere frå logginnutil her!?!
    }
    
}