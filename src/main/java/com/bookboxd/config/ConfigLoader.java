package com.bookboxd.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("jwt.properties")) {
            if (input != null) {
                props.load(input);
            } else {
                throw new RuntimeException("jwt.properties not found");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load jwt.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
