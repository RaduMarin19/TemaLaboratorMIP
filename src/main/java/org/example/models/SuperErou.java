package org.example.models;

import org.example.interfaces.ILuptator;

import java.io.Serializable;

public class SuperErou extends Personaj implements ILuptator, Serializable {
    private int slabiciune;

    public SuperErou() {}
    public SuperErou(String nume, int putere, int slabiciune) {
        super(nume, putere);
        this.slabiciune = slabiciune;
    }

    public int getSlabiciune() {
        return slabiciune;
    }

    public void setSlabiciune(int slabiciune) {
        this.slabiciune = slabiciune;
    }

    @Override
    public void prezentare() {
        System.out.println("Eu sunt " + nume + " cu o putere de " + putere + " si o slabiciune: " + slabiciune);
    }

    @Override
    public void ataca() {
        System.out.println(nume + " ataca cu puterea sa de " + putere + "!");
    }

    @Override
    public void seApara() {
        System.out.println(nume + " se apara folosind agerimea sa!");
    }
}
