package models.pages.mobile.android;

import models.pages.Page;
import org.openqa.selenium.By;

public class PreferenceDependenciesPage extends Page {
    private static final By wifiCheckBox = By.id("android:id/checkbox");
    private static final By wifiSettings = By.xpath("(//android.widget.RelativeLayout)[2]");
    private static final By wifiSettingsTextBox = By.className("android.widget.EditText");
    private static final By buttons = By.className("android.widget.Button");
    private static final By writtenText = By.xpath("//android.widget.EditText[@index='0']");

    public PreferenceDependenciesPage setWifiCheckBox(){
        phone.clickToBy(wifiCheckBox);
        return this;
    }

    public PreferenceDependenciesPage openWiFiSettingsPopup(){
        phone.clickToBy(wifiSettings);
        return this;
    }

    public PreferenceDependenciesPage type(String text){
        phone.type(wifiSettingsTextBox, text);
        return this;
    }

    public PreferenceDependenciesPage OK(){
        phone.findElements(buttons).get(1).click();
        return this;
    }

    public String getWrittenWiFiSettings(){
        return phone.findElement(writtenText).getText();
    }
}
