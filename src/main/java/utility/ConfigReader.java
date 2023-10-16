package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public Properties intializeProperties() {

        Properties prop = new Properties();
        File proFile = new File(System.getProperty("user.dir") + "/src/main/resources/config/config.properties");

        try {
            FileInputStream file = new FileInputStream(proFile);
            prop.load(file);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return prop;
    }
}
