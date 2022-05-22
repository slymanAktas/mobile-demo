package models.clients.browsers;

import io.qameta.allure.Attachment;
import models.clients.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.ScreenshotException;

import static org.openqa.selenium.OutputType.BYTES;
import static utils.FileUtils.writeFile;

public abstract class Browser extends Device {
    private static final Logger LOGGER = LogManager.getLogger(Browser.class);

    @Override
    public void close() {}

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
}
