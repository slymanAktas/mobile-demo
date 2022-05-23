package models.pages.mobile.android;

import models.pages.Page;
import org.openqa.selenium.By;

public class CustomAdapterPage extends Page {
    private static final By peopleNames = By.xpath("//android.widget.TextView[@text='People Names']");
    private static final By popupText = By.xpath("//android.widget.TextView[@text='Sample menu']");

    public CustomAdapterPage longPressToPeopleNames(){
        phone.longPress(peopleNames);
        return this;
    }

    public String getPopupText(){
        return phone.findElement(popupText).getText();
    }
}
