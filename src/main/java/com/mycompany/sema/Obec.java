/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sema;

/**
 *
 * @author ondru
 */
public class Obec {

 
    private String obec;
    private String psc; 
    private int pocetMuzu; // Počet mužů
    private int pocetZen; // Počet žen

    public Obec(String obec, String psc, int pocetMuzu, int pocetZen) {
        this.obec = obec;
        this.psc = psc;
        this.pocetMuzu = pocetMuzu;
        this.pocetZen = pocetZen;
    }

 
    public String getPsc() {
        return psc;
    }

    public String getObec() {
        return obec;
    }
    public int getPocetMuz() {
        return pocetMuzu;
    }

    public int getPocetZen() {
        return pocetZen;
    }

    public int getCelkem() {
        return pocetMuzu + pocetZen; // celkový počet obyvatel
    }
  

    @Override
    public String toString() {
        return "Obec{" +        
                ", PSC='" + psc + '\'' +
                "Obec='" + obec + '\'' +
                ", počet mužů=" + pocetMuzu +
                ", počet žen=" + pocetZen +
                ", celkem=" + getCelkem() +
                '}';
    }
}
