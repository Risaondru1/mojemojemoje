/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ondru
 */


/*


package com.mycompany.sema;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstrDoubleListTest {

    private IAbstrDoubleList<Integer> list;

    @Before
    public void setUp() {
        list = new AbstrDoubleList<>();
    }

    @Test
    public void testJePrazdny() {
        assertTrue("Seznam by měl být prázdný.", list.jePrazdny());
        list.vlozPrvni(1);
        assertFalse("Seznam by neměl být prázdný.", list.jePrazdny());
    }

    @Test
    public void testVlozPrvni() {
        list.vlozPrvni(1);
        assertEquals("První prvek by měl být 1.", Integer.valueOf(1), list.zpristupniPrvni());
        list.vlozPrvni(2);
        assertEquals("První prvek by měl být 2.", Integer.valueOf(2), list.zpristupniPrvni());
    }

    @Test
    public void testVlozPosledni() {
        list.vlozPosledni(1);
        assertEquals("Poslední prvek by měl být 1.", Integer.valueOf(1), list.zpristupniPosledni());
        list.vlozPosledni(2);
        assertEquals("Poslední prvek by měl být 2.", Integer.valueOf(2), list.zpristupniPosledni());
    }

    @Test
    public void testVlozNaslednika() {
        AbstrDoubleList<Integer> list = new AbstrDoubleList<>();
        list.vlozPrvni(1); // Přidáme první prvek
        list.nastavPrvni(); // Nastavíme aktuální prvek na první prvek
        list.vlozNaslednika(2); // Vložíme následníka pro aktuální prvek (1)

        // Zkontrolujeme, jestli je následník správně nastaven
        list.nastavPrvni(); // Nastavíme se zpět na první prvek
        assertEquals(Integer.valueOf(1), list.zpristupniAktualni()); // Aktuální prvek by měl být 1
        assertEquals(Integer.valueOf(2), list.zpristupniNaslednika()); // Následník by měl být 2
    }

    @Test(expected = IllegalStateException.class)
    public void testVlozNaslednikaBezAktualniho() {
        list.vlozNaslednika(1);
    }

    @Test
    public void testOdeberPrvni() {
        list.vlozPrvni(1);
        list.vlozPrvni(2);
        assertEquals("Odebraný prvek by měl být 2.", Integer.valueOf(2), list.odeberPrvni());
        assertEquals("První prvek by měl být 1.", Integer.valueOf(1), list.zpristupniPrvni());
    }

    @Test
    public void testOdeberPosledni() {
        list.vlozPrvni(1);
        list.vlozPosledni(2);
        assertEquals("Odebraný prvek by měl být 2.", Integer.valueOf(2), list.odeberPosledni());
        assertEquals("Poslední prvek by měl být 1.", Integer.valueOf(1), list.zpristupniPosledni());
    }

    @Test
    public void testOdeberAktualni() {
        list.vlozPrvni(1);
        list.vlozPrvni(2);
        list.nastavPrvni(); // nastavíme aktuální prvek na 2
        assertEquals("Odebraný prvek by měl být 2.", Integer.valueOf(2), list.odeberAktualni());
        assertEquals("První prvek by měl být 1.", Integer.valueOf(1), list.zpristupniPrvni());
    }

    @Test(expected = IllegalStateException.class)
    public void testOdeberAktualniBezNastaveni() {
        list.odeberAktualni();
    }

    @Test
    public void testZrus() {
        list.vlozPrvni(1);
        assertFalse("Seznam by neměl být prázdný.", list.jePrazdny());
        list.zrus();
        assertTrue("Seznam by měl být prázdný.", list.jePrazdny());
    }

    @Test
    public void testIterator() {
        list.vlozPrvni(1);
        list.vlozPosledni(2);
        list.vlozPosledni(3);

        int count = 0;
        for (Integer value : list) {
            if (count == 0) {
                assertEquals("První prvek by měl být 1.", Integer.valueOf(1), value);
            } else if (count == 1) {
                assertEquals("Druhý prvek by měl být 2.", Integer.valueOf(2), value);
            } else if (count == 2) {
                assertEquals("Třetí prvek by měl být 3.", Integer.valueOf(3), value);
            }
            count++;
        }
        assertEquals("Celkový počet prvků by měl být 3.", 3, count);
    }
}

*/