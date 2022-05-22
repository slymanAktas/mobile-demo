package models.clients.phones;

import models.clients.Device;

import java.io.File;

public abstract class Phone extends Device {

    public abstract File getAppDir();

    @Override
    public void close() {}

    @Override
    public byte[] takeScreenshot(String scrFilename) {
        return new byte[0];
    }
}
