/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.sema;

/**
 *
 * @author ondru
 */
public enum enumKraj {
    PRAHA("Hlavni mesto Praha"),
    JIHOCESKY("Jihocesky"),
    JIHOMORAVSKY("Jihomoravsky"),
    KARLOVARSKY("Karlovarsky"),
    VYSOCINA("Kraj Vysocina"),
    KRALOVEHRADECKY("Kralovehradecky"),
    LIBERECKY("Liberecky"),
    MORAVSKOSLEZSKY("Moravskoslezsky"),
    OLOMOUCKY("Olomoucky"),
    PARDUBICKY("Pardubicky"),
    PLZENSKY("Plzensky"),
    STREDOCESKY("Stredocesky"),
    USTECKY("Ustecky"),
    ZLINSKY("Zlinsky"),
    VSECHNY("Vsechny");

    private final String nazev;

    private enumKraj(String nazev) {
        this.nazev = nazev;
    }

    public static enumKraj fromNazev(String nazev) {
        for (enumKraj kraj : values()) {
            if (kraj.nazev.equalsIgnoreCase(nazev)) {
                return kraj;
            }
        }
        throw new IllegalArgumentException("Neznámý kraj: " + nazev);
    }
}
