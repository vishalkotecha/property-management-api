package com.example.propertymanager.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String value) {
        if (value == null || value.equals("")) {
            return true;
        }

        return false;
    }
}
