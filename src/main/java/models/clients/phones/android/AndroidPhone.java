package models.clients.phones.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import models.clients.phones.Phone;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.TestException;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static config.Config.LOCAL_APPIUM_HUB;
import static config.Config.REMOTE_APPIUM_HUB;

public class AndroidPhone extends Phone {
    @Override
    public void initInGrid() {
        try {
            webDriver = new AndroidDriver<>(new URL(REMOTE_APPIUM_HUB), getCapabilities());
        } catch (MalformedURLException e) {
            throw new TestException("Cannot create AndroidDriver", e);
        }
    }

    @Override
    public void initInLocal() {
        try {
            webDriver = new AndroidDriver<>(new URL(LOCAL_APPIUM_HUB), getCapabilities());
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            throw new TestException("Cannot create AndroidDriver", e);
        }
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(MobileCapabilityType.APP, getAppDir().getAbsolutePath());
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, "TiramisuEmulator");
        capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        return capability;
    }

    @Override
    public File getAppDir() {
        File apk = new File("src/main/resources/apk");
        return new File(apk, "ApiDemos-debug.apk");
    }
}
