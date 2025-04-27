package com.therapistApp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SideMenuController {
    @FXML private VBox sideMenu;
    @FXML private Button toggleButton;
    @FXML private VBox buttonContainer;
    private boolean collapsed = false;

    @FXML public void initialize() {
        toggleButton.setOnAction(e -> toggle());
    }

    private void toggle() {
        collapsed = !collapsed;
        sideMenu.setPrefWidth(collapsed ? 60 : 200);
        toggleButton.setText(collapsed ? ">" : "<");
        buttonContainer.getChildren().stream()
                .filter(n -> n instanceof Button && n != toggleButton)
                .map(n -> (Button)n)
                .forEach(btn -> btn.setText(collapsed ? "" : btn.getId()));
    }

    public VBox getButtonContainer() {
        return buttonContainer;
    }

}
