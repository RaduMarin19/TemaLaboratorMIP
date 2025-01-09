package org.example.models;

public abstract class Personaj {
    public String nume;
    public int putere;

    public Personaj() {}

    public Personaj(String nume, int putere) {
        this.nume = nume;
        this.putere = putere;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getPutere(){
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public abstract void prezentare();
}

