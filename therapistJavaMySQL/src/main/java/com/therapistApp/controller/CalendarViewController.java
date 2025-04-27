package com.therapistApp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class CalendarViewController {
    @FXML private VBox root;

    public static Node load() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                CalendarViewController.class.getResource("//panel/CalendarView.fxml")
        );
        loader.load();
        return loader.getRoot();
    }

    @FXML public void initialize() {
        // Inicializaciones específicas
    }
}
