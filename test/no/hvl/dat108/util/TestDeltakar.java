package no.hvl.dat108.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat108.entity.Deltakar;

/**
 * TestDeltakar
 */
public class TestDeltakar {

    private Deltakar d1;
    private Deltakar d2;

    @BeforeEach
    private void setup() {
        d1 = new Deltakar("Stian", "Grønås", "12345678", "mann");
        d2 = new Deltakar("Renate", "Grønås", "98765432", "kvinne");
    }

    @Test
    public void testFormatertMobilnr() {
        assertEquals("123 45 678", d1.getMobilnrFormatert());
        assertEquals("987 65 432", d2.getMobilnrFormatert());
    }

    @Test
    public void testFormatertKjoenn() {
        assertEquals("&#9794;", d1.getKjoennFormatert());
        assertEquals("&#9792;", d2.getKjoennFormatert());
    }
}