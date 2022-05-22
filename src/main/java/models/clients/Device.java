package models.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.Config.ISREMOTE;
import static models.clients.Devices.getDevice;

public abstract class Device extends SeleniumDriver {
    private static final Logger LOGGER = LogManager.getLogger(Device.class);

    public abstract void close();

    public abstract byte[] takeScreenshot(String scrFilename);

    public abstract void initInGrid();

    public abstract void initInLocal();

    public abstract DesiredCapabilities getCapabilities();

    public static Device openThe(String deviceName){
        Device device = getDevice(deviceName);
        return device.connect();
    }

    private Device connect() {
        if (ISREMOTE) {
            initInGrid();
        } else {
            initInLocal();
        }

        return this;
    }
}
