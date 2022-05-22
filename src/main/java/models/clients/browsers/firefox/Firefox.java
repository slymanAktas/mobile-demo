package models.clients.browsers.firefox;

import models.clients.browsers.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox extends Browser {
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
}
