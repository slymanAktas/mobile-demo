package models.pages.mobile.android;

import models.pages.Page;
import org.openqa.selenium.By;

public class ViewsPage extends Page {
    private static final By expandableList = By.xpath("//android.widget.TextView[@text='Expandable Lists']");
    private static final By dateWidgets = By.xpath("//android.widget.TextView[@text='Date Widgets']");
    private static final By dragAndDrop = By.xpath("//android.widget.TextView[@text='Drag and Drop']");

    public ExpandableListPage openExpandableList(){
        phone.tab(expandableList);
        return phone.returnRedirectedPage(new ExpandableListPage());
    }

    public DateWidgetsPage openDateWidgets(){
        phone.tab(dateWidgets);
        return phone.returnRedirectedPage(new DateWidgetsPage());
    }

    public DragAndDropPage openDragAndDrop(){
        phone.tab(dragAndDrop);
        return phone.returnRedirectedPage(new DragAndDropPage());
    }
}
