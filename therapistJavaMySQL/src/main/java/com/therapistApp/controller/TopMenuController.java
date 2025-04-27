package com.therapistApp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TopMenuController {
    @FXML private Label titleLabel;

    @FXML public void initialize() {
        // Ajustar título dinámico si es necesario
        titleLabel.setText("Mi Aplicación de Terapia");
    }

}
