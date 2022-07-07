package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    Properties pro;

    public PropertyReader() {
        File file = new File(System.getProperty("user.dir") + "/" + "configuration/data.properties");
        try {
            pro = new Properties();
            FileInputStream fis = new FileInputStream(file);
            pro.load(fis);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public String getImplicitWait() {
        return pro.getProperty("implicitWait");
    }

    public String getPageLoadTime() {
        return pro.getProperty("pageLoadTime");
    }


}
