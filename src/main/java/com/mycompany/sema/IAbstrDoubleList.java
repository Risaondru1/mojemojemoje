/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sema;

/**
 *
 * @author ondru
 */


public interface IAbstrDoubleList<T> extends Iterable<T> {
    void zrus();
    boolean jePrazdny();
    void vlozPrvni(T data);
    void vlozPosledni(T data);
    void vlozNaslednika(T data);
    void vlozPredchudce(T data);
    T zpristupniAktualni();
    T zpristupniPrvni();
    T zpristupniPosledni();
    T zpristupniNaslednika();
    T zpristupniPredchudce();
    T odeberAktualni();
    T odeberPrvni();
    T odeberPosledni();
    T odeberNaslednika();
    T odeberPredchudce();
    void nastavPrvni();
    void nastavPosledni();
    boolean dalsi();
    boolean predchozi();
}
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
// */
//package com.mycompany.sema;
//
///**
// *
// * @author ondru
// */
//public interface IAbstrDoubleList<T> extends Iterable<T> {
//
//    // zrušení celého seznamu,
//    void zrus();
//    
//    // test naplněnosti seznamu
//    boolean jePrazdny();
//
//    
//    
//    // vložení prvku do seznamu na první místo
//    void vlozPrvni(T data);
//
//    // vložení prvku do seznamu na poslední místo,
//    void vlozPosledni(T data);
//
//    // vložení prvku do seznamu jakožto následníka aktuálního prvku,
//    void vlozNaslednika(T data);
//
//    // vložení prvku do seznamu jakožto předchůdce aktuálního prvku,
//    void vlozPredchudce(T data);
//
//    
//    
//    // zpřístupnění aktuálního prvku seznamu,
//    T zpristupniAktualni();
//
//    // zpřístupnění prvního prvku seznamu,
//    T zpristupniPrvni();
//
//    // zpřístupnění posledního prvku seznamu,
//    T zpristupniPosledni();
//
//    // zpřístupnění následníka aktuálního prvku,
//    T zpristupniNaslednika();
//
//    // zpřístupnění předchůdce aktuálního prvku,
//    T zpristupniPredchudce();
//
//    
//    
//    // odebrání (vyjmutí) aktuálního prvku ze seznamu poté je aktuální prvek nastaven na první prvek
//    T odeberAktualni();
//
//    // odebrání prvního prvku ze seznamu,
//    T odeberPrvni();
//
//    // odebrání posledního prvku ze seznamu
//    T odeberPosledni();
//
//    // odebrání následníka aktuálního prvku ze seznamu
//    T odeberNaslednika();
//
//    // odebrání předchůdce aktuálního prvku ze seznamu
//    T odeberPredchudce();
//
//    
//    
//    // Nastaví ukazatel na první prvek
//    void nastavPrvni();
//
//    // Nastaví ukazatel na poslední prvek
//    void nastavPosledni();
//
//    // Posune ukazatel na další prvek
//    boolean dalsi();
//
//    // Posune ukazatel na předchozí prvek
//    boolean predchozi();
//    
//    java.util.Iterator<T> iterator();
//
//}
