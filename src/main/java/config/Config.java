package config;


import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class Config {
    public static final String USER_DIR;
    public static final String SCREENSHOT_PATH;
    public static final boolean ISREMOTE;
    public static final String LOCAL_APPIUM_HUB;
    public static final String REMOTE_APPIUM_HUB;
    public static final String SELENIUM_GRID_HUB_URL;
    protected static final Properties properties;

    static {
        USER_DIR = System.getProperty("user.dir");
        SCREENSHOT_PATH = USER_DIR + "/screenshots/";
        ISREMOTE = isRemote();


        properties = loadProperties();
        LOCAL_APPIUM_HUB = properties.getProperty("local.appium.hub");
        REMOTE_APPIUM_HUB = properties.getProperty("remote.appium.hub");
        SELENIUM_GRID_HUB_URL = properties.getProperty("remote.grid.hub");
    }

    private static Properties loadProperties() {
        String configFileName = "properties/config.properties";
        InputStream in = ClassLoader.getSystemResourceAsStream(configFileName);
        Properties properties = new Properties();

        try {
            properties.load(in);
        } catch (IOException ioe) {
            throw new IllegalStateException("Exception on loading {" + configFileName + "} conf file from classpath", ioe);
        }
        return properties;
    }

    private static boolean isRemote() {
        String remoteValue = System.getProperties().getProperty("remote");

        boolean remote = false;
        if (Objects.isNull(remoteValue)) {
            remote = Boolean.parseBoolean(remoteValue);
        }
        return remote;
    }
}
