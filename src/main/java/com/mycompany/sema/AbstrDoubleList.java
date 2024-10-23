/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sema;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author ondru
 */
public class AbstrDoubleList<T> implements IAbstrDoubleList<T> {

    // Vnitřní třída pro uzel seznamu
    private class Node {

        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
            this.next = this.prev = this; // cyklické propojení na sebe sama
        }
    }

    private Node head;  // Odkaz na první uzel
    private Node aktualni;  // Odkaz na aktuální uzel
    private int size;  // Velikost seznamu

    public AbstrDoubleList() {
        head = null;  // Inicializace prázdného seznamu
        aktualni = null;
        size = 0;
    }

    public void nastavAktualniIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Neplatný index: " + index);
        }
        aktualni = head;
        for (int i = 0; i < index; i++) {
            aktualni = aktualni.next;
        }
    }

    public int size() {
        return size;
    }

    public void addFirst(T data) {
        vlozPrvni(data);
    }

    public void addLast(T data) {
        vlozPosledni(data);
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Neplatný index: " + index);
        }
        if (index == 0) {
            vlozPrvni(data);
        } else if (index == size) {
            vlozPosledni(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public boolean isEmpty() {
        return jePrazdny();
    }

    public T getFirst() {
        if (jePrazdny()) {
            throw new IllegalStateException("Seznam je prázdný.");
        }
        return head.data;
    }

    public T getLast() {
        if (jePrazdny()) {
            throw new IllegalStateException("Seznam je prázdný.");
        }
        return head.prev.data;
    }

    public int indexOf(T data) {
        if (jePrazdny()) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(data)) {
                return i;
            }
            current = current.next;
        }
        return -1; // Prvek nebyl nalezen
    }

    public void clear() {
        zrus();
    }

    @Override
    public void zrus() {
        head = null;
        aktualni = null;
        size = 0;
    }

    @Override
    public boolean jePrazdny() {
        return size == 0;
    }

    @Override
    public void vlozPrvni(T data) {
        Node newNode = new Node(data);
        if (jePrazdny()) {
            head = newNode;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void vlozPosledni(T data) {
        if (jePrazdny()) {
            vlozPrvni(data);
        } else {
            Node newNode = new Node(data);
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
            size++;
        }
    }

    @Override
    public void vlozNaslednika(T data) {
        if (aktualni == null) {
            throw new IllegalStateException("Aktuální prvek není nastaven.");
        }
        Node newNode = new Node(data);
        Node nextNode = aktualni.next;
        newNode.next = nextNode;
        newNode.prev = aktualni;
        aktualni.next = newNode;
        nextNode.prev = newNode;
        size++;
    }

    @Override
    public void vlozPredchudce(T data) {
        if (aktualni == null) {
            throw new IllegalStateException("Aktuální prvek není nastaven.");
        }
        Node newNode = new Node(data);
        Node prevNode = aktualni.prev;
        newNode.next = aktualni;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        aktualni.prev = newNode;
        size++;
    }

    @Override
    public T zpristupniAktualni() {
        if (aktualni == null) {
            throw new IllegalStateException("Aktuální prvek není nastaven.");
        }
        return aktualni.data;
    }

    @Override
    public T zpristupniPrvni() {
        if (jePrazdny()) {
            throw new IllegalStateException("Seznam je prázdný.");
        }
        aktualni = head;
        return head.data;
    }

    @Override
    public T zpristupniPosledni() {
        if (jePrazdny()) {
            throw new IllegalStateException("Seznam je prázdný.");
        }
        aktualni = head.prev;
        return aktualni.data;
    }

    @Override
    public T zpristupniNaslednika() {
        if (aktualni == null || aktualni.next == head) {
            throw new IllegalStateException("Aktuální prvek nebo jeho následník není k dispozici.");
        }
        aktualni = aktualni.next;
        return aktualni.data;
    }

    @Override
    public T zpristupniPredchudce() {
        if (aktualni == null || aktualni.prev == head.prev) {
            throw new IllegalStateException("Aktuální prvek nebo jeho předchůdce není k dispozici.");
        }
        aktualni = aktualni.prev;
        return aktualni.data;
    }

    @Override
    public T odeberAktualni() {
        if (aktualni == null) {
            throw new IllegalStateException("Aktuální prvek není nastaven.");
        }
        T data = aktualni.data;
        if (aktualni == head) {
            return odeberPrvni();
        } else if (aktualni == head.prev) {
            return odeberPosledni();
        } else {
            Node prevNode = aktualni.prev;
            Node nextNode = aktualni.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
        aktualni = head;  // Nastavení aktuálního na první prvek
        return data;
    }

    @Override
    public T odeberPrvni() {
        if (jePrazdny()) {
            throw new IllegalStateException("Seznam je prázdný.");
        }
        T data = head.data;
        if (size == 1) {
            zrus();
        } else {
            Node last = head.prev;
            head = head.next;
            last.next = head;
            head.prev = last;
            size--;
        }
        return data;
    }

    @Override
    public T odeberPosledni() {
        if (jePrazdny()) {
            throw new IllegalStateException("Seznam je prázdný.");
        }
        if (size == 1) {
            return odeberPrvni();
        }
        Node last = head.prev;
        T data = last.data;
        Node newLast = last.prev;
        newLast.next = head;
        head.prev = newLast;
        size--;
        return data;
    }

    @Override
    public T odeberNaslednika() {
        if (aktualni == null || aktualni.next == head) {
            throw new IllegalStateException("Aktuální prvek nebo jeho následník není k dispozici.");
        }
        aktualni = aktualni.next;
        return odeberAktualni();
    }

    @Override
    public T odeberPredchudce() {
        if (aktualni == null || aktualni.prev == head.prev) {
            throw new IllegalStateException("Aktuální prvek nebo jeho předchůdce není k dispozici.");
        }
        aktualni = aktualni.prev;
        return odeberAktualni();
    }

    @Override
    public void nastavPrvni() {
        if (!jePrazdny()) {
            aktualni = head;
        }
    }

    @Override
    public void nastavPosledni() {
        if (!jePrazdny()) {
            aktualni = head.prev;
        }
    }

    @Override
    public boolean dalsi() {
        if (aktualni == null || aktualni.next == head) {
            return false;
        }
        aktualni = aktualni.next;
        return true;
    }

    @Override
    public boolean predchozi() {
        if (aktualni == null || aktualni.prev == head.prev) {
            return false;
        }
        aktualni = aktualni.prev;
        return true;
    }

    private class DoubleListIterator implements Iterator<T> {

        private Node aktualniNode = head; // Začínáme od prvního uzlu
        private boolean started = false; // Pro detekci prvního volání next()

        @Override
        public boolean hasNext() {
            if (size == 0) {
                return false;
            }
            return !started || aktualniNode != head;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = aktualniNode.data;
            aktualniNode = aktualniNode.next;
            started = true;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Odstranění není podporováno.");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleListIterator();
    }

}

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.sema;
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
///**
// *
// * @author ondru
// */
///*Ctrl F OTAZKA*/
//    public class AbstrDoubleList<T> implements IAbstrDoubleList<T> {
//
//    // Vnitřní třída pro uzel seznamu
//    private class Node {
//        T data;
//        Node next;
//        Node prev;
//
//        
//        Node(T data) {
//            this.data = data;
//            this.next = this.prev = this; // cyklické propojení na sebe sama
//        }
//    }
//
//    private Node head;  // Odkaz na první uzel
//    private Node aktualni;  // Odkaz na aktuální uzel
//    private int size;  // Velikost seznamu
//
//    public AbstrDoubleList() {
//        head = null;  // Inicializace prázdného seznamu
//        aktualni = null;
//        size = 0;
//    }
//
//     // Zrušení celého seznamu
//    @Override
//    public void zrus() {
//        head = null;
//        aktualni = null;
//        size = 0;
//    }
//    //OTAZKA Test, zda je seznam prázdný - -test naplněnosti seznamu,
//    @Override
//    public boolean jePrazdny() {
//        return size == 0;
//    }
//    
//   
//    // Vložení prvku do seznamu na první místo
//    @Override
//    public void vlozPrvni(T data) {
//        Node newNode = new Node(data);
//        if (jePrazdny()) {
//            head = newNode;
//        } else {
//            Node last = head.prev;
//            newNode.next = head;
//            newNode.prev = last;
//            last.next = newNode;
//            head.prev = newNode;
//            head = newNode;
//        }
//        size++;
//    }
//  
//    //vložení prvku do seznamu na poslední místo,
//    @Override
//    public void vlozPosledni(T data) {
//        if (jePrazdny()) {
//            vlozPrvni(data);
//        } else {
//            Node newNode = new Node(data);
//            Node last = head.prev;
//            newNode.next = head;
//            newNode.prev = last;
//            last.next = newNode;
//            head.prev = newNode;
//            size++;
//        }
//    }
//    
//    //vložení prvku do seznamu jakožto následníka aktuálního prvku
//    @Override
//    public void vlozNaslednika(T data) {
//        if (aktualni == null) {
//            throw new IllegalStateException("Aktuální prvek není nastaven.");
//        }
//        Node newNode = new Node(data);
//        Node nextNode = aktualni.next;
//        newNode.next = nextNode;
//        newNode.prev = aktualni;
//        aktualni.next = newNode;
//        nextNode.prev = newNode;
//        size++;
//    }
//
//    //vložení prvku do seznamu jakožto předchůdce aktuálního prvku,
//    @Override
//    public void vlozPredchudce(T data) {
//        if (aktualni == null) {
//            throw new IllegalStateException("Aktuální prvek není nastaven.");
//        }
//        Node newNode = new Node(data);
//        Node prevNode = aktualni.prev;
//        newNode.next = aktualni;
//        newNode.prev = prevNode;
//        prevNode.next = newNode;
//        aktualni.prev = newNode;
//        size++;
//    }
//    
//   //zpřístupnění aktuálního prvku seznamu,
//    @Override
//    public T zpristupniAktualni() {
//        if (aktualni == null) {
//            throw new IllegalStateException("Aktuální prvek není nastaven.");
//        }
//        return aktualni.data;
//    }
//    
//    @Override
//    public T zpristupniPrvni() {
//        if (jePrazdny()) {
//            throw new IllegalStateException("Seznam je prázdný.");
//        }
//        aktualni = head;
//        return head.data;
//    }
//
//    // Zpřístupnění posledního prvku
//    @Override
//    public T zpristupniPosledni() {
//        if (jePrazdny()) {
//            throw new IllegalStateException("Seznam je prázdný.");
//        }
//        aktualni = head.prev;
//        return aktualni.data;
//    }
//
//    // Zpřístupnění následníka aktuálního prvku
//    @Override
//    public T zpristupniNaslednika() {
//        if (aktualni == null) {
//            throw new IllegalStateException("Aktuální prvek nebo jeho následník není k dispozici.");
//        }
//        aktualni = aktualni.next;
//        return aktualni.data;
//    }
//
//    // Zpřístupnění předchůdce aktuálního prvku
//    @Override
//    public T zpristupniPredchudce() {
//        if (aktualni == null || aktualni.prev == head.prev) {
//            throw new IllegalStateException("Aktuální prvek nebo jeho předchůdce není k dispozici.");
//        }
//        aktualni = aktualni.prev;
//        return aktualni.data;
//    }
//    
//    // Odebrání aktuálního prvku
//    @Override
//    public T odeberAktualni() {
//        if (aktualni == null) {
//            throw new IllegalStateException("Aktuální prvek není nastaven.");
//        }
//        T data = aktualni.data;
//        if (aktualni == head) {
//            odeberPrvni();
//        } else if (aktualni == head.prev) {
//            odeberPosledni();
//        } else {
//            Node prevNode = aktualni.prev;
//            Node nextNode = aktualni.next;
//            prevNode.next = nextNode;
//            nextNode.prev = prevNode;
//            size--;
//        }
//        aktualni = head;  // Nastavení aktuálního na první prvek
//        return data;
//    }
//
//    // Odebrání prvního prvku
//    @Override
//    public T odeberPrvni() {
//        if (jePrazdny()) {
//            throw new IllegalStateException("Seznam je prázdný.");
//        }
//        T data = head.data;
//        if (size == 1) {
//            zrus();
//        } else {
//            Node last = head.prev;
//            head = head.next;
//            last.next = head;
//            head.prev = last;
//            size--;
//        }
//        return data;
//    }
//
//    //odebrání posledního prvku ze seznamu
//    @Override
//    public T odeberPosledni() {
//        if (jePrazdny()) {
//            throw new IllegalStateException("Seznam je prázdný.");
//        }
//        if (size == 1) {
//            return odeberPrvni();
//        }
//        Node last = head.prev;
//        T data = last.data;
//        Node newLast = last.prev;
//        newLast.next = head;
//        head.prev = newLast;
//        size--;
//        return data;
//    }
//
//    
//
//    
//     // Odebrání následníka aktuálního prvku
//    @Override
//    public T odeberNaslednika() {
//        if (aktualni == null || aktualni.next == head) {
//            throw new IllegalStateException("Aktuální prvek nebo jeho následník není k dispozici.");
//        }
//        aktualni = aktualni.next;
//        return odeberAktualni();
//    }
//
//    // Odebrání předchůdce aktuálního prvku
//    @Override
//    public T odeberPredchudce() {
//        if (aktualni == null || aktualni.prev == head.prev) {
//            throw new IllegalStateException("Aktuální prvek nebo jeho předchůdce není k dispozici.");
//        }
//        aktualni = aktualni.prev;
//        return odeberAktualni();
//    }
//    
//    
//    
//    
//    
//    
//    
//    
//    // Implementace iteratoru jako vnitřní třídy
//    private class DoubleListIterator implements Iterator<T> {
//        private Node aktualniNode = head; // Začínáme od prvního uzlu
//        private boolean started = false; // Pro detekci prvního volání next()
//
//        @Override
//        public boolean hasNext() {
//            // Pokud je seznam prázdný, žádný další prvek není
//            if (size == 0) {
//                return false;
//            }
//            // Pokud iterace právě začala nebo aktuální uzel není zpět na prvním uzlu
//            return !started || aktualniNode != head;
//        }
//
//        @Override
//        public T next() {
//            if (!hasNext()) {
//                throw new NoSuchElementException();
//            }
//            T data = aktualniNode.data; // Získání dat z aktuálního uzlu
//            aktualniNode = aktualniNode.next; // Přechod na další uzel
//            started = true; // Nyní jsme začali iteraci
//            return data;
//        }
//
//        @Override
//        public void remove() {
//            throw new UnsupportedOperationException("Odstranění není podporováno.");
//        }
//    }
//
//    // Implementace metody iterator() z Iterable
//    @Override
//    public Iterator<T> iterator() {
//        return new DoubleListIterator(); // Vracení nové instance iterátoru
//    }
//    
//  
//    
//    
//    @Override
//    public void nastavPrvni() {
//        if (!jePrazdny()) {
//            aktualni = head;
//        }
//    }
//
//    @Override
//    public void nastavPosledni() {
//        if (!jePrazdny()) {
//            aktualni = head.prev;
//        }
//    }
//
//    @Override
//    public boolean dalsi() {
//        if (aktualni == null || aktualni.next == head) {
//            return false;
//        }
//        aktualni = aktualni.next;
//        return true;
//    }
//
//    @Override
//    public boolean predchozi() {
//        if (aktualni == null || aktualni.prev == head.prev) {
//            return false;
//        }
//        aktualni = aktualni.prev;
//        return true;
//    }
//
//    
//
//    
//    
//}
//
