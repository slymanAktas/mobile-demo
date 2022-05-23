package models.clients.phones.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import models.clients.phones.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.TestException;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static config.Config.LOCAL_APPIUM_HUB;
import static config.Config.REMOTE_APPIUM_HUB;

public class AndroidPhone extends Phone {
    private static final Logger LOGGER = LogManager.getLogger(AndroidPhone.class);

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

    public AndroidDriver getDriver() {
        return ((AndroidDriver) this.webDriver);
    }

    public WebElement getElementWithText(String text) {
        return getDriver().findElementByAndroidUIAutomator("text(\"" + text + "\")");
    }

    @Override
    public void scrollUntilElement(By by) {
        String text = findElement(by).getText();
        try{
            scrollUntil(text);
        }catch (Exception e){
            LOGGER.error("Couldn't scroll element with by attribute via AndroidUIAutomator...");
        }

    }

    @Override
    public void hideKeyboard() {
        try {
            getDriver().hideKeyboard();
        } catch (WebDriverException wde) {
            LOGGER.warn(wde);
        }
    }

    public void scrollUntil(String text){
        getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
    }
}
