package com.therapistApp.controller;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

public class ViewController {
    private final BorderPane root;
    private final VBox sideMenu;
    private final Button toggleButton;

    public ViewController() {
        root = new BorderPane();

        // Inicializar menú lateral
        sideMenu = new VBox(10);
        sideMenu.setPadding(new Insets(10));
        sideMenu.setStyle("-fx-background-color: #2D2D2D;");
        sideMenu.setPrefWidth(200);

        toggleButton = new Button("<");
        toggleButton.setOnAction(e -> toggleSideMenu());

        initTopMenu();
        initSideMenu();

        // Área central placeholder
        root.setCenter(new StackPane());
    }

    private void initTopMenu() {
        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(10));
        topMenu.setStyle("-fx-background-color: #2D2D2D;");
        Label title = new Label("Mi Aplicación de Terapia");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
        topMenu.getChildren().add(title);
        root.setTop(topMenu);
    }

    private void initSideMenu() {
        sideMenu.getChildren().add(toggleButton);
        ScrollPane scroll = new ScrollPane(sideMenu);
        scroll.setFitToWidth(true);
        root.setLeft(scroll);
    }

    private void toggleSideMenu() {
        if (sideMenu.getPrefWidth() > 60) {
            sideMenu.setPrefWidth(60);
            toggleButton.setText(">");
        } else {
            sideMenu.setPrefWidth(200);
            toggleButton.setText("<");
        }
    }

    public BorderPane getRoot() {
        return root;
    }
}