package models.pages.mobile.android;

import models.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DragAndDropPage extends Page {
    private static final By statusMsgIndex = By.xpath("//android.widget.TextView[@index='4']");

    public DragAndDropPage dragElementThanDrop(){
        List<WebElement> draggedBowls = phone.findElements(By.className("android.view.View"));
        phone.dragAndDrop(
            draggedBowls.get(0),
            draggedBowls.get(1)
        );
        return this;
    }

    public String getStatusMsg(){
        return phone.findElement(statusMsgIndex).getText();
    }
}
