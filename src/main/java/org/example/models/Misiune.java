package org.example.models;

public class Misiune {
    private String nume;
    private int dificultate;
    private int recompensa;

    public Misiune() {
    }

    public Misiune(String nume, int dificultate, int recompensa) {
        this.nume = nume;
        this.dificultate = dificultate;
        this.recompensa = recompensa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getDificultate() {
        return dificultate;
    }

    public void setDificultate(int dificultate) {
        this.dificultate = dificultate;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }

    public void prezentare() {
        System.out.println("Misiune: " + nume);
        System.out.println("Dificultate: " + dificultate);
        System.out.println("Recompensa: " + recompensa);
    }

    public boolean finalizeazaMisiune(SuperErou erou) {
        if (erou.getPutere() >= dificultate) {
            System.out.println(erou.getNume() + " a finalizat misiunea " + nume + " si a castigat " + recompensa + " puncte!");
            return true;
        } else {
            System.out.println(erou.getNume() + " nu are suficienta putere pentru a finaliza misiunea " + nume + ".");
            return false;
        }
    }
}
