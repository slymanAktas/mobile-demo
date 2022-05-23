package models.pages.mobile.android;

import models.pages.Page;
import org.openqa.selenium.By;

public class ViewsPage extends Page {
    private static final By expandableList = By.xpath("//android.widget.TextView[@text='Expandable Lists']");

    public ExpandableListPage openExpandableList(){
        phone.tab(expandableList);
        return phone.returnRedirectedPage(new ExpandableListPage());
    }
}
