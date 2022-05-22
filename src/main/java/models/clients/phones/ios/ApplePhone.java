package models.clients.phones.ios;

import models.clients.phones.Phone;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class ApplePhone extends Phone {
    @Override
    public void initInGrid() {

    }

    @Override
    public void initInLocal() {

    }

    @Override
    public DesiredCapabilities getCapabilities() {
        return null;
    }

    @Override
    public File getAppDir() {
        return null;
    }
}
