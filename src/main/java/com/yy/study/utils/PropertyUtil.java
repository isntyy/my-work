package com.yy.study.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyUtil {
    public static Properties getProperties(String propertyFile) throws IOException {
        Properties properties = new Properties();
        try (
                InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream(propertyFile);
                InputStreamReader is = new InputStreamReader(in, "utf-8")
        ) {
            properties.load(is);
        }
        return properties;
    }
}
