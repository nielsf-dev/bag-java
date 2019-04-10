package org.bag;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

    private static final String DEFAULT_CONFIG_FILE_LOCATION = "config.properties";

    private String configFileLocation;

    private Properties properties;

    public PropertyUtil() throws IOException {

        this(DEFAULT_CONFIG_FILE_LOCATION);
    }

    public PropertyUtil(String configFileLocation) throws IOException {

        this.configFileLocation = configFileLocation;
        this.properties = new Properties();
        init();
    }

    private void init() throws IOException {

        properties.load(new FileInputStream(this.configFileLocation));

        for (Object key : this.properties.keySet()) {

            String override = System.getProperty((String) key);

            if (override != null) {

                properties.put(key, override);
            }
        }
    }

    public int getIntProperty(String key) {

        return this.properties.contains(key) ? Integer.parseInt(properties.getProperty(key)) : null;
    }

    public String getStringProperty(String key) {

        return (String) this.properties.get(key);
    }
}
