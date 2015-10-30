package com.augmentum.examonline.until;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropertiesUtil {
    private static Properties p = null;
    static {
        InputStream in = null;
        try {
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream("app.properties");
            p = new Properties();
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static String getProperty(String key) {
        return p.getProperty(key);
    }
    public static void main(String[] args) {
        System.out.println(PropertiesUtil.getProperty("jdbc.driver"));
    }
    public static String getStaticUrl() {
        return p.getProperty("static_url");
    }

}