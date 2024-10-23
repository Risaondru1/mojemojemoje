package com.mycompany.sema;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LayoutikController {

    @FXML
    private TextField textFieldNazevObce;
    @FXML
    private TextField textFieldPsc;
    @FXML
    private TextField textFieldPocetMuzu;
    @FXML
    private TextField textFieldPocetZen;
    @FXML
    private TextField textFieldKraj;
    @FXML
    private TextField textFieldSoubor;
    @FXML
    private TextField textFieldPozice;

    @FXML
    private TextArea textAreaOutput;

    private Obyvatele obyvatelstvo = new Obyvatele();

    @FXML
    private void handleAddObec() {
        String nazevObce = textFieldNazevObce.getText();
        String psc = textFieldPsc.getText();
        int pocetMuzu = Integer.parseInt(textFieldPocetMuzu.getText());
        int pocetZen = Integer.parseInt(textFieldPocetZen.getText());
        String kraj = textFieldKraj.getText();
        enumKraj vybranyKraj = enumKraj.valueOf(kraj.toUpperCase());

        Obec novaObec = new Obec(nazevObce, psc, pocetMuzu, pocetZen);
        obyvatelstvo.vlozObec(novaObec, enumPozice.POSLEDNI, vybranyKraj);
        textAreaOutput.appendText("Obec byla úspěšně přidána!\n");
    }

    @FXML
    private void handleImportData() {
        String soubor = textFieldSoubor.getText();
        int pocetZaznamu = obyvatelstvo.importData(soubor);
        textAreaOutput.appendText(pocetZaznamu + " záznamů bylo importováno z " + soubor + "\n");
    }

    @FXML
    private void handleZpristupniObec() {
        String pozice = textFieldPozice.getText();
        String kraj = textFieldKraj.getText();
        enumPozice enumPoz = enumPozice.valueOf(pozice.toUpperCase());
        enumKraj vybranyKraj = enumKraj.valueOf(kraj.toUpperCase());

        Obec obec = obyvatelstvo.zpristupniObec(enumPoz, vybranyKraj);
        textAreaOutput.appendText("Zpřístupněna obec: " + obec + "\n");
    }

    @FXML
    private void handleZobrazObce() {
        String kraj = textFieldKraj.getText();
        enumKraj vybranyKraj = enumKraj.valueOf(kraj.toUpperCase());

        obyvatelstvo.zobrazObce(vybranyKraj);
    }

    @FXML
    private void handleOdeberObec() {
        String pozice = textFieldPozice.getText();
        String kraj = textFieldKraj.getText();
        enumPozice enumPoz = enumPozice.valueOf(pozice.toUpperCase());
        enumKraj vybranyKraj = enumKraj.valueOf(kraj.toUpperCase());

        Obec odebranaObec = obyvatelstvo.odeberObec(enumPoz, vybranyKraj);
        textAreaOutput.appendText("Odebrána obec: " + odebranaObec + "\n");
    }

    @FXML
    private void handleZjistiPrumer() {
        String kraj = textFieldKraj.getText();
        enumKraj vybranyKraj = enumKraj.valueOf(kraj.toUpperCase());

        float prumer = obyvatelstvo.zjistiPrumer(vybranyKraj);
        textAreaOutput.appendText("Průměr obyvatel v kraji " + vybranyKraj + " je " + prumer + "\n");
    }

    @FXML
    private void handleZobrazObceNadPrumer() {
        String kraj = textFieldKraj.getText();
        enumKraj vybranyKraj = enumKraj.valueOf(kraj.toUpperCase());

        obyvatelstvo.zobrazObceNadPrumer(vybranyKraj);
    }

    @FXML
    private void handleZrusObce() {
        String kraj = textFieldKraj.getText();
        enumKraj vybranyKraj = enumKraj.valueOf(kraj.toUpperCase());

        obyvatelstvo.zrus(vybranyKraj);
        textAreaOutput.appendText("Obce v kraji " + vybranyKraj + " byly zrušeny.\n");
    }

    @FXML
    private void handleUlozDoSouboru() {
        String soubor = textFieldSoubor.getText();
        String kraj = textFieldKraj.getText();
        enumKraj vybranyKraj = enumKraj.valueOf(kraj.toUpperCase());

        obyvatelstvo.ulozDoSouboru(soubor, vybranyKraj);
        textAreaOutput.appendText("Data byla uložena do souboru: " + soubor + "\n");
    }

}

//package com.mycompany.sema;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.fxml.FXML;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//
//public class LayoutikController {
//
//    @FXML
//    private TextField textFieldNazevObce;
//    @FXML
//    private TextField textFieldPsc;
//    @FXML
//    private TextField textFieldPocetMuzu;
//    @FXML
//    private TextField textFieldPocetZen;
//    @FXML
//    private TextField textFieldKraj;
//    @FXML
//    private TextArea textAreaOutput;
//
//    private Obyvatele obyvatelstvo = new Obyvatele();
//
////    @FXML
////private void handleAddObec() {
////    String nazevObce = textFieldNazevObce.getText();
////    String psc = textFieldPsc.getText();
////    int pocetMuzu = Integer.parseInt(textFieldPocetMuzu.getText());
////    int pocetZen = Integer.parseInt(textFieldPocetZen.getText());
////    String kraj = textFieldKraj.getText();
////    enumKraj vybranyKraj = enumKraj.valueOf(kraj.toUpperCase());
////
////    Obec novaObec = new Obec(nazevObce, psc, pocetMuzu, pocetZen);
////    obyvatelstvo.vlozObec(novaObec, enumPozice.POSLEDNI, vybranyKraj);
////    textAreaOutput.appendText("Obec byla úspěšně přidána!\n");
////}
////
////
////    @FXML
////    private void handleImportData() {
////        obyvatelstvo.importData("C:\\Users\\ondru\\Documents\\NetBeansProjects\\sema\\src\\kraje.csv");
////        textAreaOutput.appendText("Data byla importována!\n");
////    }
//    @FXML
//    private void handleImportData() {
//        String soubor = textFieldSoubor.getText();
//        int pocetZaznamu = obyvatelstvo.importData(soubor);
//        textAreaOutput.appendText(pocetZaznamu + " záznamů bylo importováno z " + soubor + "\n");
//    }
//
////
////    @FXML
////    private void handleZobrazObce() {
////        enumKraj kraj = enumKraj.valueOf(textFieldKraj.getText().toUpperCase());
////        obyvatelstvo.zobrazObce(kraj);
////    }
////
////    @FXML
////    private void handleZobrazObceNadPrumer() {
////        enumKraj kraj = enumKraj.valueOf(textFieldKraj.getText().toUpperCase());
////        obyvatelstvo.zobrazObceNadPrumer(kraj);
////    }
////
////    @FXML
////    private void handleZrusObce() {
////        enumKraj kraj = enumKraj.valueOf(textFieldKraj.getText().toUpperCase());
////        obyvatelstvo.zrus(kraj);
////        textAreaOutput.appendText("Obce byly zrušeny!\n");
////    }
////}
////package com.mycompany.sema;
////
////import javafx.fxml.FXML;
////import javafx.scene.control.*;
////import javafx.scene.control.ListView;
////
////public class LayoutikController {
////
////    @FXML
////    private ListView<Obec> listViewObce;
////
////    @FXML
////    private TextField textFieldObec;
////
////    @FXML
////    private TextField textFieldPsc;
////
////    @FXML
////    private TextField textFieldPocetMuzu;
////
////    @FXML
////    private TextField textFieldPocetZen;
////
////    @FXML
////    private Label labelStatus;
////
////    private Obyvatele obyvatele;// = new Obyvatele(); // Instance Obyvatele
////
////    @FXML
////    public void initialize() {
////        // Načti data do ListView na začátku
////        zobrazObce(enumKraj.VYSOCINA);
////    }
////
////    @FXML
////    public void pridatObec() {
////        String nazevObce = textFieldObec.getText();
////        String psc = textFieldPsc.getText();
////        int pocetMuzu = Integer.parseInt(textFieldPocetMuzu.getText());
////        int pocetZen = Integer.parseInt(textFieldPocetZen.getText());
////
////        Obec novaObec = new Obec(nazevObce, psc, pocetMuzu, pocetZen);
////        obyvatele.vlozObec(novaObec, enumPozice.POSLEDNI, enumKraj.VYSOCINA);
////
////        zobrazObce(enumKraj.VYSOCINA);
////        labelStatus.setText("Obec přidána: " + novaObec);
////
////        // Vyprázdni textová pole
////        textFieldObec.clear();
////        textFieldPsc.clear();
////        textFieldPocetMuzu.clear();
////        textFieldPocetZen.clear();
////    }
////
////    @FXML
////    public void ulozDoSouboru() {
////        // Uložení dat do souboru
////        obyvatele.ulozDoSouboru("obce.txt", enumKraj.VYSOCINA);
////        labelStatus.setText("Data byla uložena do souboru.");
////    }
////
////    private void zobrazObce(enumKraj kraj) {
////        listViewObce.getItems().clear(); // Vyčisti ListView
////        AbstrDoubleList<Obec> obceList = obyvatele.getObce(kraj); // Použití nového názvu
////        // Přidání obcí do ListView
////        for (Obec obec : obceList) {
////            listViewObce.getItems().add(obec);
////        }
////    }
////
////}
