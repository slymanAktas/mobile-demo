package models.pages.mobile.android;

import models.pages.Page;
import org.openqa.selenium.By;

public class ClockPage extends Page {
    private static final By selectedMinute = By.xpath("//android.widget.TextView[@index='2']");

    public ClockPage setClockAs(String from, String to) {
        phone.tab(By.xpath("//*[@content-desc='3']"));
        phone.swipe(
                By.xpath("//*[@content-desc='" + from + "']"),
                By.xpath("//*[@content-desc='" + to + "']")
        );
        return this;
    }

    public String getSelectedMinuteFromClock(){
        return phone.findElement(selectedMinute).getText();
    }
}
