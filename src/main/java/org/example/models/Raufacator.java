package org.example.models;

import org.example.interfaces.ILuptator;

import java.io.Serializable;

public class Raufacator extends Personaj implements ILuptator, Serializable {

    public Raufacator() {}
    public Raufacator(String nume, int putere) {
        super(nume, putere);
    }

    @Override
    public void prezentare() {
        System.out.println("Eu sunt raufacatorul " + nume + " cu o putere de " + putere);
    }

    @Override
    public void ataca() {
        System.out.println(nume + " ataca cu viclenie si putere de " + putere + "!");
    }

    @Override
    public void seApara() {
        System.out.println(nume + " se apara folosind trucuri murdare!");
    }

}
