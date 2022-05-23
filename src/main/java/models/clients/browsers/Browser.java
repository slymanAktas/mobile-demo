package models.clients.browsers;

import models.clients.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Browser extends Device {
    private static final Logger LOGGER = LogManager.getLogger(Browser.class);
}
