package com.therapistApp.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    public void init(Stage stage) throws IOException {
        MainViewController mvc = MainViewController.load();
        // Cargar vista inicial:
        mvc.setCenterContent(CalendarViewController.load());

        Scene scene = new Scene(mvc.getRoot());
        stage.setTitle("Mi Aplicación de Terapia");
        stage.setScene(scene);
        stage.show();
    }

}