package models.pages.mobile.android;

import models.pages.Page;
import org.openqa.selenium.By;

public class ExpandableListPage extends Page {
    private static final By customAdapter = By.xpath("//android.widget.TextView[@text='1. Custom Adapter']");

    public CustomAdapterPage openCustomAdapterPage(){
        phone.tab(customAdapter);
        return phone.returnRedirectedPage(new CustomAdapterPage());
    }
}
