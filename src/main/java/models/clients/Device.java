package models.clients;

import models.pages.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static config.Config.ISREMOTE;
import static models.clients.Devices.getDevice;

public abstract class Device extends SeleniumDriver {
    private static final Logger LOGGER = LogManager.getLogger(Device.class);

    private Page page;

    public void close() {
        this.webDriver.quit();
    }

    public abstract byte[] takeScreenshot(String scrFilename);

    public abstract void initInGrid();

    public abstract void initInLocal();

    public static Device openThe(String deviceName) {
        Device device = getDevice(deviceName);
        return device.connect();
    }

    public Device changePage(Page page) {
        this.page = page;
        this.page.setDevice(this);
        return this;
    }

    public Device setPage(Page page) {
        return changePage(page);
    }

    private Device connect() {
        if (ISREMOTE) {
            initInGrid();
        } else {
            initInLocal();
        }
        return this;
    }

    public final Page page() {
        return this.page;
    }

    public <T extends Page> T returnRedirectedPage(T pageWillBeReturned) {
        changePage(pageWillBeReturned);
        return pageWillBeReturned;
    }
}
