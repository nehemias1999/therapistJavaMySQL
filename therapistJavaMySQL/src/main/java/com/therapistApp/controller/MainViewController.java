package com.therapistApp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class MainViewController {
    @FXML private BorderPane root;
    @FXML private StackPane contentPane;

    public static MainViewController load() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                MainViewController.class.getResource("/com/therapistApp/view/MainView.fxml")
        );
        loader.load();
        return loader.getController();
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setCenterContent(javafx.scene.Node node) {
        contentPane.getChildren().setAll(node);
    }

    @FXML public void initialize() {
        // Inicializar contenido si hace falta
    }

}
