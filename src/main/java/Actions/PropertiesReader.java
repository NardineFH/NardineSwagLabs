package Actions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String getProperties(String filename , String properties) throws IOException {
        String data;
        FileReader reader=new FileReader(filename);
        Properties p = new Properties() ;

        p.load(reader);
       data = p.getProperty(properties);
        return  data;
    }
}
