package com.mycompany.sema;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Sema extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layoutik.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Moje Aplikace");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//package com.mycompany.sema;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class Sema extends Application {
//
//    
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layoutik.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Moje Aplikace");
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}






//
//package com.mycompany.sema;
//
//import java.util.Scanner;
//
///**
// *
// * @author ondru
// */
//public class Sema {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Obyvatele obyvatelstvo = new Obyvatele();
//
//        // Importujeme data z CSV souboru
//        System.out.println("Importuji data...");
//        obyvatelstvo.importData("C:\\Users\\ondru\\Documents\\NetBeansProjects\\sema\\src\\kraje.csv");
//        System.out.println("Data importov�na.");
//
//        /*NA��T�N� Z KL�VESNICE - ZA��TEK*/
//        System.out.println("Zadejte n�zev nov� vytvo�en�  obce:");
//        String nazevObce = scanner.nextLine();
//        System.out.println("Zadejte PS�:");
//        String psc = scanner.nextLine();
//        System.out.println("Zadejte po�et mu��:");
//        int pocetMuzu = scanner.nextInt();
//        System.out.println("Zadejte po�et �en:");
//        int pocetZen = scanner.nextInt();
//        scanner.nextLine();  // Spot�ebov�n� nov� ��dky
//
//        Obec novaObec = new Obec(nazevObce, psc, pocetMuzu, pocetZen);
//        System.out.println("Vyberte kraj pro novou obec:");
//        for (enumKraj kraj : enumKraj.values()) {
//            System.out.println(kraj);
//        }
//        String vybranyKraj = scanner.nextLine();
//        enumKraj kraj = enumKraj.valueOf(vybranyKraj.toUpperCase());
//
//        obyvatelstvo.vlozObec(novaObec, enumPozice.POSLEDNI, kraj);
//        System.out.println("Obec byla �sp�n� p�id�na!");
//
//        // Zobraz�me obce pro dan� kraj
//        System.out.println("Zobrazuj� se obce kraje " + kraj + "...");
//        obyvatelstvo.zobrazObce(kraj);
//
//        
//        /*NA��T�N� Z KL�VESNICE - KONEC*/
//
//        /*GENEROV�N� DAT - ZA��TEK*/
////        System.out.println("Kolik obc� chcete vygenerovat?");
////        int pocetObci = scanner.nextInt();
////        scanner.nextLine(); // Spot�ebov�n� nov� ��dky
////        System.out.println("Vyberte kraj pro generov�n� obc�:");
////        for (enumKraj kraj : enumKraj.values()) {
////            System.out.println(kraj);
////        }
////        String vybranyKraj = scanner.nextLine();
////        enumKraj kraj = enumKraj.valueOf(vybranyKraj.toUpperCase());
////
////        obyvatelstvo.generujData(pocetObci, kraj);
////        System.out.println(pocetObci + " obc� bylo vygenerov�no pro kraj " + kraj);
////
////        // Zobraz�me obce pro dan� kraj
////        System.out.println("Zobrazuj� se obce kraje " + kraj + "...");
////        obyvatelstvo.zobrazObce(kraj);
////
////       
//        /*GENEROV�N� DAT - KONEC*/
//        
//        /*ULO�EN� OBC� DO SOUBORU - ZA��TEK*/
//        System.out.println("Zadejte n�zev souboru pro ulo�en� dat (nutno p�idat p��ponu .txt):");
//        String nazevSouboru = scanner.nextLine();
//        obyvatelstvo.ulozDoSouboru(nazevSouboru, kraj);
//        /*ULO�EN� OBC� DO SOUBORU - KONEC*/
//
// /*Hooodn� v�c�*/
////        // P�id�me novou obec na r�zn� pozice v kraji VYSOCINA
////        Obec novaObec = new Obec("Nova Obec", "12345", 500, 600);
////        Obec novaObec1 = new Obec("Risovi Vary", "54321", 1, 555);
////        Obec novaObec2 = new Obec("Michalovo Ghetto", "66566", 999, 868);
////
////        System.out.println("Vkl�d�m obec na prvn� pozici...");
////        obyvatelstvo.vlozObec(novaObec1, enumPozice.PRVNI, enumKraj.VYSOCINA);
////        System.out.println("Obec vlo�ena na prvn� pozici.");
////
////        System.out.println("Vkl�d�m obec na posledn� pozici...");
////        obyvatelstvo.vlozObec(novaObec, enumPozice.POSLEDNI, enumKraj.VYSOCINA);
////        System.out.println("Obec vlo�ena na posledn� pozici.");
////
////        System.out.println("Vkl�d�m obec jako n�sledn�ka...");
////        obyvatelstvo.vlozObec(novaObec2, enumPozice.NASLEDNIK, enumKraj.PARDUBICKY);
////        System.out.println("Obec vlo�ena jako n�sledn�k.");
////        System.out.println("Vkl�d�m obec jako p�edch�dce...");
////        obyvatelstvo.vlozObec(novaObec, enumPozice.PREDCHUDCE, enumKraj.VYSOCINA);
////        System.out.println("Obec vlo�ena jako p�edch�dce.");
//// Nastaven� a zp��stupn�n� aktu�ln� obce
////
////        // Zp��stupn�me obce na r�zn�ch pozic�ch
////        Obec prvniObec = obyvatelstvo.zpristupniObec(enumPozice.PRVNI, enumKraj.VYSOCINA);
////        System.out.println("Prvn� obec: " + prvniObec);
////
////        Obec posledniObec = obyvatelstvo.zpristupniObec(enumPozice.POSLEDNI, enumKraj.VYSOCINA);
////        System.out.println("Posledn� obec: " + posledniObec);
////
////        Obec nasledujiciObec = obyvatelstvo.zpristupniObec(enumPozice.NASLEDNIK, enumKraj.VYSOCINA);
////        System.out.println("N�sleduj�c� obec: " + nasledujiciObec);
////
////        Obec predchudceObec = obyvatelstvo.zpristupniObec(enumPozice.PREDCHUDCE, enumKraj.VYSOCINA);
////        System.out.println("P�edch�dce obec: " + predchudceObec);
////
////
////        /*OTAZKA NASLEDUJICI A PREDCHAZEJICI OBEC JSOU NULL*/
////        
////        
////        // Nastaven� a zp��stupn�n� aktu�ln� obce
////        obyvatelstvo.nastavAktualniIndex(8); // P�edpokl�d�me prvn� obec jako aktu�ln�
////        Obec aktualniObec = obyvatelstvo.zpristupniObec(enumPozice.AKTUALNI, enumKraj.VYSOCINA);
////        System.out.println("Aktu�ln� obec: " + aktualniObec);
////        // Zp��stupn�n� n�sleduj�c� a p�edch�zej�c� obce
////        try {
////            Obec naslednaObec = obyvatelstvo.zpristupniObec(enumPozice.NASLEDNIK, enumKraj.VYSOCINA);
////            System.out.println("N�sleduj�c� obec: " + nasledujiciObec);
////        } catch (Exception e) {
////            System.out.println("Chyba p�i p��stupu k n�sleduj�c� obci: " + e.getMessage());
////        }
////
////        try {
////            Obec predchazejiciObec = obyvatelstvo.zpristupniObec(enumPozice.PREDCHUDCE, enumKraj.VYSOCINA);
////            System.out.println("P�edch�zej�c� obec: " + predchazejiciObec);
////        } catch (Exception e) {
////            System.out.println("Chyba p�i p��stupu k p�edch�zej�c� obci: " + e.getMessage());
////        }
////
////   
//// Nastav�me aktu�ln� index (p�edpokl�d�me prvn� obec jako aktu�ln�)
////
////        obyvatelstvo.nastavAktualniIndex(8); 
////        Obec odebranaNasledujici = obyvatelstvo.odeberObec(enumPozice.NASLEDNIK, enumKraj.VYSOCINA);
////        System.out.println("Odebran� n�sleduj�c� obec: " + odebranaNasledujici);
////
////
////        // Zobraz�me obce pro dan� kraj
////        System.out.println("Zobrazuj� se obce vybran�ho kraje...");
////        obyvatelstvo.zobrazObce(enumKraj.VYSOCINA);
////        
//////        // Zru��me v�echny obce v kraji Vyso�ina
////        System.out.println("Ru��m obce v kraji Vyso�ina...");
////        obyvatelstvo.zrus(enumKraj.VYSOCINA);
////        System.out.println("Obce byly zru�eny.");
////// Zobraz�me obce pro dan� kraj znova aby bylo videt ze byly zruseny
////        System.out.println("Zobrazuj� se obce vybran�ho kraje...");
////        obyvatelstvo.zobrazObce(enumKraj.VYSOCINA);
////        
//scanner.close();
//    }
//}
