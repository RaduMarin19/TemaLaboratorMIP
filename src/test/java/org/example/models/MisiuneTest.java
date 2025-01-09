package org.example.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MisiuneTest {
    private Misiune misiune;
    private SuperErou erou;

    @BeforeEach
    void setUp() {
        misiune = new Misiune("Salvare", 50, 100);
        erou = new SuperErou("Superman", 60, 40);
    }

    @Test
    void testConstructorCuParametri() {
        assertEquals("Salvare", misiune.getNume());
        assertEquals(50, misiune.getDificultate());
        assertEquals(100, misiune.getRecompensa());
    }

    @Test
    void testConstructorFaraParametri() {
        Misiune misiuneGoala = new Misiune();
        assertNull(misiuneGoala.getNume());
        assertEquals(0, misiuneGoala.getDificultate());
        assertEquals(0, misiuneGoala.getRecompensa());
    }

    @Test
    void testGetAndSetNume() {
        misiune.setNume("Noua Misiune");
        assertEquals("Noua Misiune", misiune.getNume());
    }

    @Test
    void testGetAndSetDificultate() {
        misiune.setDificultate(70);
        assertEquals(70, misiune.getDificultate());
    }

    @Test
    void testGetAndSetRecompensa() {
        misiune.setRecompensa(200);
        assertEquals(200, misiune.getRecompensa());
    }

    @Test
    void testFinalizeazaMisiuneReusita() {
        assertTrue(misiune.finalizeazaMisiune(erou));
    }

    @Test
    void testFinalizeazaMisiuneEsuata() {
        SuperErou erouSlab = new SuperErou("Batman", 30, 10);
        assertFalse(misiune.finalizeazaMisiune(erouSlab));
    }

    @Test
    void testPrezentare() {
        assertDoesNotThrow(() -> misiune.prezentare());
    }
}
