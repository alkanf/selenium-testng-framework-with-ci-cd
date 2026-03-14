package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
//InputStream is more dynamic than fileinputstream
        try {
        	InputStream file = ConfigReader.class
        	        .getClassLoader()
        	        .getResourceAsStream("config.properties");

        	properties = new Properties();
        	properties.load(file);
        } catch (IOException e) {

            throw new RuntimeException("Config file not found");
        }
    }
//Access files without creating object
    public static String getProperty(String key) {

        return properties.getProperty(key);

    }

}