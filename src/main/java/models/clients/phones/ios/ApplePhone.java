package models.clients.phones.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import models.clients.phones.Phone;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.TestException;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static config.Config.LOCAL_APPIUM_HUB;
import static config.Config.REMOTE_APPIUM_HUB;

public class ApplePhone extends Phone {
    @Override
    public void initInGrid() {
        try {
            webDriver = new IOSDriver<>(new URL(REMOTE_APPIUM_HUB), getCapabilities());
        } catch (MalformedURLException e) {
            throw new TestException("Cannot create AndroidDriver", e);
        }
    }

    @Override
    public void initInLocal() {
        try {
            webDriver = new IOSDriver<>(new URL(LOCAL_APPIUM_HUB), getCapabilities());
        } catch (MalformedURLException e) {
            throw new TestException("Cannot create AndroidDriver", e);
        }
    }

    @Override
    public DesiredCapabilities getCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 50000);
        capabilities.setCapability("commandTimeouts", 50000);
        capabilities.setCapability(MobileCapabilityType.APP, getAppDir().getAbsolutePath());

        return capabilities;
    }

    @Override
    public void scrollUntilElement(By by) {
    }

    @Override
    public void hideKeyboard() {
    }

    @Override
    public File getAppDir() {
        File apk = new File("src/main/resources/app");
        return new File(apk, "ApiDemos-debug.app");
    }
}
