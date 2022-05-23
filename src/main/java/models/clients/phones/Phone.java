package models.clients.phones;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import models.clients.Device;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.time.Duration;

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

    public abstract void scrollUntilElement(By by);

    public abstract void hideKeyboard();

    public void tab(By by) {
        new TouchAction(getDriver()).tap(
                tapOptions().withElement(element(findElement(by)))
        ).perform();
    }

    public void clickToBy(By by) {
        findElement(15, by).click();
    }

    public void longPress(By by) {
        new TouchAction(getDriver()).longPress(
                longPressOptions().withElement(element(findElement(by)))
        ).perform();
    }

    public void swipe(By from, By to) {
        new TouchAction(getDriver())
                .longPress(longPressOptions()
                        .withElement(element(findElement(from)))
                        .withDuration(Duration.ofSeconds(2)))
                .moveTo(element(findElement(to)))
                .release()
                .perform();
    }

    public void dragAndDrop(By source, By destination) {
        dragAndDrop(findElement(source), findElement(destination));
    }

    public void dragAndDrop(WebElement source, WebElement destination) {
        new TouchAction(getDriver())
                .longPress(longPressOptions().withElement(element(source)))
                .moveTo(element(destination))
                .release()
                .perform();
    }

    public void type(By by, String text, boolean clear) {
        scrollUntilElement(by);
        WebElement element = findElement(by);
        if (clear) {
            element.clear();
        }
        element.sendKeys(text);
        hideKeyboard();
    }

    public void type(By by, String text) {
        type(by, text, false);
    }
}
