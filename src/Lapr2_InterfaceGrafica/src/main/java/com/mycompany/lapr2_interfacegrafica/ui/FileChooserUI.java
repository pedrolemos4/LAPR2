package com.mycompany.lapr2_interfacegrafica.ui;

import javafx.stage.FileChooser;

/**
 *
 * @author beatr
 */
public class FileChooserUI {
    private FileChooser fileChooser;

    private FileChooserUI() {
        fileChooser = new FileChooser();
        associarFiltro("File Transactions", "*.txt");
    }

    public static FileChooser criarFileChooser() {
        FileChooserUI listTransactions = new FileChooserUI();
        return listTransactions.fileChooser;
    }

    private void associarFiltro(String description, String extension) {
        FileChooser.ExtensionFilter filtro = new FileChooser.ExtensionFilter(description, extension);
        fileChooser.getExtensionFilters().add(filtro);
    }
}
