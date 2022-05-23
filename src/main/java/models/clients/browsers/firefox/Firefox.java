package models.clients.browsers.firefox;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import models.clients.browsers.Browser;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.TestException;

import java.net.MalformedURLException;
import java.net.URL;

import static config.Config.SELENIUM_GRID_HUB_URL;

public class Firefox extends Browser {
    @Override
    public void initInGrid() {
        try {
            webDriver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB_URL), getOptions());
            webDriver.manage().window().setSize(new Dimension(1216, 1024));
            ((RemoteWebDriver) webDriver).setFileDetector(new LocalFileDetector());
        } catch (MalformedURLException mue) {
            throw new TestException(mue);
        }
    }

    @Override
    public void initInLocal() {
        FirefoxDriverManager.getInstance().setup();
        webDriver = new FirefoxDriver(getOptions());
    }

    private static FirefoxOptions getOptions() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", "localhost");
        profile.setPreference("network.proxy.http_port", 1080);

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("firefox_profile", profile);
        return options;
    }
}
