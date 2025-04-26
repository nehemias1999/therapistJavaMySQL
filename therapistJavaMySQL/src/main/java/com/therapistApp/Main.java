package com.therapistApp;

import com.therapistApp.controller.Controller;
import com.therapistApp.exception.ValidationException;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ValidationException, SQLException {
        new Controller();
    }

}
