package com.digital.skills.challenge.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHelper {

    public static Properties getInstance() {
        return new PropertyHelper().getProperties();
    }

    private Properties getProperties() {

        String fileName = "config.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

}
