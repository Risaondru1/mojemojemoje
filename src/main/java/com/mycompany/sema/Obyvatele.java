/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sema;

/**
 *
 * @author ondru
 */
/*OTAZKA*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Obyvatele {

    private int aktualniIndex = -1; // Inicializace na -1 znamen�, �e aktu�ln� prvek nen� nastaven

    // Mapov�n� ID na enumKraj
    private static final Map<Integer, enumKraj> idToKrajMap = new HashMap<>();
    private final Map<enumKraj, AbstrDoubleList<Obec>> obce;

    static {
        idToKrajMap.put(1, enumKraj.PRAHA);
        idToKrajMap.put(2, enumKraj.JIHOCESKY);
        idToKrajMap.put(3, enumKraj.JIHOMORAVSKY);
        idToKrajMap.put(4, enumKraj.KARLOVARSKY);
        idToKrajMap.put(5, enumKraj.VYSOCINA);
        idToKrajMap.put(6, enumKraj.KRALOVEHRADECKY);
        idToKrajMap.put(7, enumKraj.LIBERECKY);
        idToKrajMap.put(8, enumKraj.MORAVSKOSLEZSKY);
        idToKrajMap.put(9, enumKraj.OLOMOUCKY);
        idToKrajMap.put(10, enumKraj.PARDUBICKY);
        idToKrajMap.put(11, enumKraj.PLZENSKY);
        idToKrajMap.put(12, enumKraj.STREDOCESKY);
        idToKrajMap.put(13, enumKraj.USTECKY);
        idToKrajMap.put(14, enumKraj.ZLINSKY);
        idToKrajMap.put(15, enumKraj.VSECHNY);
    }

    public void nastavAktualniIndex(int index) {
        if (index >= 0 && index < obce.get(enumKraj.VYSOCINA).size()) {
            this.aktualniIndex = index;
        } else {
            throw new IllegalArgumentException("Neplatn� index: " + index);
        }
    }

    public Obyvatele() {
        obce = new HashMap<>();
        for (enumKraj kraj : enumKraj.values()) {
            obce.put(kraj, new AbstrDoubleList<>()); // Pou�ijeme AbstrDoubleList
        }
    }

    public int importData(String soubor) {
        int pocetZaznamu = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                // Rozd�len� ��dku st�edn�kem
                String[] data = radek.split(";");

                String nazevKraje = data[1];              // N�zev kraje
                String psc = data[2];      // PS�
                String obec = data[3];              // N�zev m�sta
                int pocetMuzu = Integer.parseInt(data[4]); // Po�et mu��
                int pocetZen = Integer.parseInt(data[5]);  // Po�et �en
                int pocetCelkem = Integer.parseInt(data[6]); // Po�et lid� celkem

                enumKraj kraj = enumKraj.fromNazev(nazevKraje);
                //             System.out.println("Importuji: " + obec + ", kraj: " + kraj); // Ladic� v�pis, import mi po p�ti dnech funguje juchuuuuuuu :)

                Obec novaObec = new Obec(obec, psc, pocetMuzu, pocetZen);
                vlozObec(novaObec, enumPozice.POSLEDNI, kraj); // Vlo��me obec na posledn� pozici
                pocetZaznamu++;
            }
        } catch (IOException e) {
            System.out.println("Chyba pri nacteni souboru: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Chybny nazev kraje: " + e.getMessage());
        }

        return pocetZaznamu;  // Vrac� po�et �sp�n� na�ten�ch z�znam�
    }

    public void vlozObec(Obec obec, enumPozice pozice, enumKraj kraj) {
        AbstrDoubleList<Obec> seznam = obce.get(kraj);
        switch (pozice) {
            case PRVNI:
                seznam.addFirst(obec);
                break;
            case POSLEDNI:
                seznam.addLast(obec);
                break;
            case NASLEDNIK:
                // P�edpokl�d�me, �e "aktu�ln�" prvek je posledn� prvek v seznamu
                if (!seznam.isEmpty() && seznam.size() > 1) {
                    int index = seznam.indexOf(seznam.getLast());
                    seznam.add(index + 1, obec);
                } else {
                    seznam.addLast(obec);
                }
                break;
            case PREDCHUDCE:
                if (!seznam.isEmpty() && seznam.size() > 1) {
                    int index = seznam.indexOf(seznam.getFirst());
                    seznam.add(Math.max(0, index - 1), obec);
                } else {
                    seznam.addFirst(obec);
                }
                break;
            case AKTUALNI:
                seznam.addLast(obec);
                break;
        }
    }

    public Obec zpristupniObec(enumPozice pozice, enumKraj kraj) {
        AbstrDoubleList<Obec> seznam = obce.get(kraj);
        if (seznam == null || seznam.jePrazdny()) {
            throw new IllegalStateException("Seznam obci je prazdny nebo neexistuje.");
        }

        int indexAktualni = aktualniIndex;

        switch (pozice) {
            case PRVNI:
                return seznam.zpristupniPrvni();
            case POSLEDNI:
                return seznam.zpristupniPosledni();
            case NASLEDNIK:
                if (indexAktualni >= 0 && indexAktualni < seznam.size() - 1) {
                    seznam.nastavAktualniIndex(indexAktualni);
                    return seznam.zpristupniNaslednika();
                }
                return null;
            case PREDCHUDCE:
                if (indexAktualni > 0 && indexAktualni < seznam.size()) {
                    seznam.nastavAktualniIndex(indexAktualni);
                    return seznam.zpristupniPredchudce();
                }
                return null;
            case AKTUALNI:
                if (indexAktualni >= 0 && indexAktualni < seznam.size()) {
                    return seznam.zpristupniAktualni();
                }
                return null;
            default:
                throw new IllegalArgumentException("Neznama pozice: " + pozice);
        }
    }

    public Obec odeberObec(enumPozice pozice, enumKraj kraj) {
        AbstrDoubleList<Obec> seznam = obce.get(kraj);
        if (seznam == null || seznam.jePrazdny()) {
            throw new IllegalStateException("Seznam obci je prazdny nebo neexistuje.");
        }

        switch (pozice) {
            case PRVNI:
                return seznam.odeberPrvni();
            case POSLEDNI:
                return seznam.odeberPosledni();
            case NASLEDNIK:
                if (aktualniIndex >= 0 && aktualniIndex < seznam.size() - 1) {
                    seznam.nastavAktualniIndex(aktualniIndex);
                    return seznam.odeberNaslednika();
                }
                return null;
            case PREDCHUDCE:
                if (aktualniIndex > 0 && aktualniIndex < seznam.size()) {
                    seznam.nastavAktualniIndex(aktualniIndex);
                    return seznam.odeberPredchudce();
                }
                return null;
            case AKTUALNI:
                if (aktualniIndex >= 0 && aktualniIndex < seznam.size()) {
                    seznam.nastavAktualniIndex(aktualniIndex);
                    return seznam.odeberAktualni();
                }
                return null;
            default:
                throw new IllegalArgumentException("Neznama pozice: " + pozice);
        }
    }

    public float zjistiPrumer(enumKraj kraj) {
        if (kraj == enumKraj.VSECHNY) {
            float total = 0;
            int count = 0;
            for (AbstrDoubleList<Obec> seznam : obce.values()) {
                for (Obec obec : seznam) {
                    total += obec.getCelkem();
                    count++;
                }
            }
            return total / count;
        } else {
            AbstrDoubleList<Obec> seznam = obce.get(kraj);
            float total = 0;
            for (Obec obec : seznam) {
                total += obec.getCelkem();
            }
            return total / seznam.size();
        }
    }

    public void zobrazObce(enumKraj kraj) {
        if (kraj == enumKraj.VSECHNY) {
            for (enumKraj k : enumKraj.values()) {
                zobrazObce(k);
            }
        } else {
            for (Obec obec : obce.get(kraj)) {
                System.out.println(obec);
            }
        }
        // Pokud je vybr�n enumKraj.VSECHNY, projdeme v�echny kraje

    }

    public void zobrazObceNadPrumer(enumKraj kraj) {
        float prumer = zjistiPrumer(kraj);
        if (kraj == enumKraj.VSECHNY) {
            for (enumKraj k : enumKraj.values()) {
                zobrazObceNadPrumer(k);
            }
        } else {
            for (Obec obec : obce.get(kraj)) {
                if (obec.getCelkem() > prumer) {
                    System.out.println(obec);
                }
            }
        }
    }

    public void zrus(enumKraj kraj) {
        if (kraj == enumKraj.VSECHNY) {
            for (enumKraj k : enumKraj.values()) {
                obce.get(k).clear();
            }
        } else {
            obce.get(kraj).clear();
        }
    }
    private static final String[] NAHODNA_SLOVA = {
        "Mesto", "More", "Kure", "Staveni", "Zena", "Ruze", "Pisen", "Kost", "Pan", "Hrad", "Muz", "Stroj", "Predseda", "Soudce"
    };

    private static String generujNahodneSlovo() {
        int index = (int) (Math.random() * NAHODNA_SLOVA.length);
        return NAHODNA_SLOVA[index];
    }

    public void generujData(int pocetObci, enumKraj kraj) {
        for (int i = 1; i <= pocetObci; i++) {
            String nazevObce = generujNahodneSlovo() + " " + i;
            int psc = 6000 + (int) (Math.random() * 1000);
            int pocetMuzu = (int) (Math.random() * 1000);
            int pocetZen = (int) (Math.random() * 1000);
            Obec novaObec = new Obec(nazevObce, Integer.toString(psc), pocetMuzu, pocetZen);
            vlozObec(novaObec, enumPozice.POSLEDNI, kraj);
        }
    }

    public void ulozDoSouboru(String nazevSouboru, enumKraj kraj) {
        try (PrintWriter writer = new PrintWriter(nazevSouboru)) {
            for (Obec obec : obce.get(kraj)) {
                writer.println(obec);
            }
            System.out.println("Data byla ulozena do souboru: " + nazevSouboru);
        } catch (IOException e) {
            System.out.println("Chyba pri zapisu do souboru: " + e.getMessage());
        }
    }

    

    public AbstrDoubleList<Obec> getObce(enumKraj kraj) {
        return obce.get(kraj); // Vr�t� seznam obc� pro dan� kraj
    }
    

    

}
