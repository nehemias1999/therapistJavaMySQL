package com.therapistApp;

import javafx.application.Application;
import javafx.stage.Stage;
import com.therapistApp.controller.Controller2;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Controller2 controller = new Controller2();
        controller.init(stage);
    }

}