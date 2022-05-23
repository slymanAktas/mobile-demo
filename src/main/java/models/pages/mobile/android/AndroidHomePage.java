package models.pages.mobile.android;

import models.pages.Page;
import org.openqa.selenium.By;

public class AndroidHomePage extends Page {
    private static final By views = By.xpath("//android.widget.TextView[@text='Views']");
    private static final By preference = By.xpath("//android.widget.TextView[@text='Preference']");

    public ViewsPage openViews(){
        phone.tab(views);
        return phone.returnRedirectedPage(new ViewsPage());
    }

    public PreferencePage openPreference(){
        phone.tab(preference);
        return phone.returnRedirectedPage(new PreferencePage());
    }
}
