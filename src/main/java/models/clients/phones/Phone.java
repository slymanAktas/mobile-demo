package models.clients.phones;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import models.clients.Device;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public abstract class Phone extends Device {

    public AppiumDriver getDriver() {
        return this.webDriver instanceof AndroidDriver ? (AndroidDriver) this.webDriver : (IOSDriver) this.webDriver;
    }

    public abstract File getAppDir();

    public abstract DesiredCapabilities getCapabilities();

    @Override
    public byte[] takeScreenshot(String scrFilename) {
        return new byte[0];
    }

    public void tab(By by) {
        new TouchAction(getDriver()).tap(
                tapOptions().withElement(
                        element(findElement(by))
                )
        ).perform();
    }

    public void clickTo(By by){
        findElement(15, by).click();
    }

    public void longPress(By by){
        new TouchAction(getDriver()).longPress(
                longPressOptions().withElement(
                        element(findElement(by))
                )
        ).perform();
    }
}
