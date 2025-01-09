package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RaufacatorTest {

    @Test
    void testGetNume() {
        Raufacator raufacator = new Raufacator("Radu", 33);
        assertEquals("Radu", raufacator.getNume());
    }

    @Test
    void testGetPutere() {
        Raufacator raufacator = new Raufacator("Radu", 33);
        assertEquals(33, raufacator.getPutere());
    }

    @Test
    void testSetNume() {
        Raufacator raufacator = new Raufacator("Radu", 33);
        raufacator.setNume("Ion");
        assertEquals("Ion", raufacator.getNume());
    }

    @Test
    void testSetPutere() {
        Raufacator raufacator = new Raufacator("Radu", 33);
        raufacator.setPutere(50);
        assertEquals(50, raufacator.getPutere());
    }

    @Test
    void testPrezentare() {
        Raufacator raufacator = new Raufacator("Radu", 33);
        raufacator.prezentare();
    }

    @Test
    void testAtaca() {
        Raufacator raufacator = new Raufacator("Radu", 33);
        raufacator.ataca();
    }

    @Test
    void testSeApara() {
        Raufacator raufacator = new Raufacator("Radu", 33);
        raufacator.seApara();
    }
}
