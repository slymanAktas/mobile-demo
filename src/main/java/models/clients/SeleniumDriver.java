package models.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SeleniumDriver {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumDriver.class);

    protected WebDriver webDriver;

    public void waitForPresenceOf(int seconds, By elementLocator) {
        WebDriverWait wait = new WebDriverWait(webDriver, seconds);
        wait.until(visibilityOfElementLocated(elementLocator));
    }

    public WebElement findElement(By by) {
        return findElement(by, null);
    }

    private WebElement findElement(By by, WebElement element) {
        List<WebElement> elements;
        if (element != null) {
            elements = element.findElements(by);
        } else {
            elements = webDriver.findElements(by);
        }
        return elements.isEmpty() ? null : elements.get(0);
    }

    public WebElement findElement(int timeout, By by) {
        waitForPresenceOf(timeout, by);
        return findElement(by, null);
    }
}
