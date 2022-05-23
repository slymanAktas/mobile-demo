package models.pages.mobile.android;

import models.pages.Page;
import org.openqa.selenium.By;

public class DateWidgetsPage extends Page {
    private static final By inline = By.xpath("//android.widget.TextView[@text='2. Inline']");

    public ClockPage openClock(){
        phone.tab(inline);
        return phone.returnRedirectedPage(new ClockPage());
    }
}
