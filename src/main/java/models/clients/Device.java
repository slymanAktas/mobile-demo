package models.clients;

import io.qameta.allure.Attachment;
import models.pages.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.ScreenshotException;

import static config.Config.ISREMOTE;
import static models.clients.Devices.getDevice;
import static org.openqa.selenium.OutputType.BYTES;
import static utils.FileUtils.writeFile;

public abstract class Device extends SeleniumDriver {
    private static final Logger LOGGER = LogManager.getLogger(Device.class);

    private Page page;

    public void close() {
        this.webDriver.quit();
    }

    @Attachment(value = "Fail screenshot", type = "image/png")
    public byte[] takeScreenshot(String scrFilename) {
        byte[] byteArray = new byte[0];
        try {
            byteArray = ((TakesScreenshot) webDriver).getScreenshotAs(BYTES);
            writeFile(scrFilename, byteArray);
        } catch (ScreenshotException sse) {
            LOGGER.error("Taking screenshot has been failed, " + sse);
        }
        return byteArray;
    }

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
