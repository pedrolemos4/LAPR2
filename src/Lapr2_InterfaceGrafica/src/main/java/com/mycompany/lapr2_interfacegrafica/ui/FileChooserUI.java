package com.mycompany.lapr2_interfacegrafica.ui;

import javafx.stage.FileChooser;

public class FileChooserUI {
    private FileChooser fileChooser;

    private FileChooserUI() {
        fileChooser = new FileChooser();
        extensionFilter("File Transactions", "*.csv");
        extensionFilter("File Transactions", "*.txt");
    }

    public static FileChooser criarFileChooser() {
        FileChooserUI listTransactions = new FileChooserUI();
        return listTransactions.fileChooser;
    }

    private void extensionFilter(String description, String extension) {
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter(description, extension);
        fileChooser.getExtensionFilters().add(filter);
    }
}
