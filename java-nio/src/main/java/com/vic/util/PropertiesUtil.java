package com.vic.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    public static String get(String key) throws IOException {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.out.println("No this key");
            e.printStackTrace();
        }
        throw new IOException();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(PropertiesUtil.get("port"));
    }
}
