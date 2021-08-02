package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
  File src;
  FileInputStream fis;
  Properties prop;

  public void loadPropertyFile() throws IOException {
    src = new File("./config/config.properties");
    fis = new FileInputStream(src);
    prop = new Properties();
    prop.load(fis);
  }

  public String getProperty(String propKey){
    return prop.getProperty(propKey);
  }
}
