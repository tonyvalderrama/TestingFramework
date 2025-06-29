package com.epam.training.tony_valderrama.service;

import java.util.ResourceBundle;

public class TestUserData {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
