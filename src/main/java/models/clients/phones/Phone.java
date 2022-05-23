package models.clients.phones;

import models.clients.Device;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public abstract class Phone extends Device {

    public abstract File getAppDir();

    public abstract DesiredCapabilities getCapabilities();

    @Override
    public void close() {}

    @Override
    public byte[] takeScreenshot(String scrFilename) {
        return new byte[0];
    }
}
