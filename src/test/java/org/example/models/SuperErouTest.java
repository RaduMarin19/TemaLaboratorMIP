package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuperErouTest {

    @Test
    void testGetNume() {
        SuperErou superErou = new SuperErou("Ion", 50, 10);
        assertEquals("Ion", superErou.getNume());
    }

    @Test
    void testGetPutere() {
        SuperErou superErou = new SuperErou("Ion", 50, 10);
        assertEquals(50, superErou.getPutere());
    }

    @Test
    void testGetSlabiciune() {
        SuperErou superErou = new SuperErou("Ion", 50, 10);
        assertEquals(10, superErou.getSlabiciune());
    }

    @Test
    void testSetNume() {
        SuperErou superErou = new SuperErou("Ion", 50, 10);
        superErou.setNume("George");
        assertEquals("George", superErou.getNume());
    }

    @Test
    void testSetPutere() {
        SuperErou superErou = new SuperErou("Ion", 50, 10);
        superErou.setPutere(80);
        assertEquals(80, superErou.getPutere());
    }

    @Test
    void testSetSlabiciune() {
        SuperErou superErou = new SuperErou("Ion", 50, 10);
        superErou.setSlabiciune(20);
        assertEquals(20, superErou.getSlabiciune());
    }

    @Test
    void testPrezentare() {
        SuperErou superErou = new SuperErou("Ion", 50, 10);
        superErou.prezentare();
    }

    @Test
    void testAtaca() {
        SuperErou superErou = new SuperErou("Ion", 50, 10);
        superErou.ataca();
    }

    @Test
    void testSeApara() {
        SuperErou superErou = new SuperErou("Ion", 50, 10);
        superErou.seApara();
    }
}
