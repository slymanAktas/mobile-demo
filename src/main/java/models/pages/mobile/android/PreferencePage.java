package models.pages.mobile.android;

import models.pages.Page;
import org.openqa.selenium.By;

public class PreferencePage extends Page {
    private static final By preferenceDependencies = By.xpath("//android.widget.TextView[@text='3. Preference dependencies']");

    public PreferenceDependenciesPage openPreferenceDependencies(){
        phone.tab(preferenceDependencies);
        return phone.returnRedirectedPage(new PreferenceDependenciesPage());
    }
}
