package models.clients.browsers.chrome;

import base.TestContext;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import models.clients.browsers.Browser;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.DateUtils;
import utils.TestException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static config.Config.SELENIUM_GRID_HUB_URL;

public class Chrome extends Browser {
    @Override
    public void initInGrid() {
        try {
            webDriver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB_URL), getOptions(true));
            System.setProperty("webdriver.chrome.silentOutput", "true"); // İgnore ChromeDriver warnings
            webDriver.manage().window().setSize(new Dimension(1216, 1024));
            ((RemoteWebDriver) webDriver).setFileDetector(new LocalFileDetector());
        } catch (MalformedURLException mue) {
            throw new TestException(mue);
        }
    }

    @Override
    public void initInLocal() {
        ChromeDriverManager.getInstance().version("101.0.4951.41").setup();
        webDriver = new ChromeDriver(getOptions(false));
        webDriver.manage().window().maximize();
    }

    public ChromeOptions getOptions(boolean isHeadless) {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.setCapability("acceptInsecureCerts", true);
        options.setCapability("name", TestContext.get().getTestMethodName() + " - " + DateUtils.getDateNow("ddMMyyyy hhmmss"));

        List<String> arguments = new ArrayList<>(Arrays.asList(
                "--headless",
                "--start-maximized",
                "--test-type",
                "--no-sandbox",
                "--ignore-certificate-errors",
                "--disable-popup-blocking",
                "--disable-default-apps",
                "--disable-extensions-file-access-check",
                "--incognito",
                "--disable-gpu",
                "--disable-features=CookiesWithoutSameSiteMustBeSecure,SameSiteByDefaultCookies,#CookiesWithoutSameSiteMustBeSecure",
                "window-position=1620,0",
                "--disable-notifications",
                "disable-infobars"
        ));

        int index = isHeadless ? 0 : 10;

        for (int i = index; i < arguments.size(); i++) {
            options.addArguments(arguments.get(i));
        }

        return options;
    }
}
