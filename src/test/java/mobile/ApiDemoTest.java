package mobile;

import base.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import models.clients.DeviceType;
import models.pages.mobile.android.*;
import models.visitors.Visitor;
import models.visitors.VisitorPool;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ApiDemoTest extends BaseTest {

    @Test
    public void shouldSeeSampleMenuPopupWhenPressAndHoldPeopleNames() {
        Visitor visitor = VisitorPool.anonymous().openApp(DeviceType.ANDROID);
        AndroidHomePage homePage = (AndroidHomePage) visitor.nowLookingAt();
        CustomAdapterPage customAdapterPage = homePage
                .openViews()
                .openExpandableList()
                .openCustomAdapterPage()
                .longPressToPeopleNames();

        assertThat("People names popup text displayed by mistake", customAdapterPage.getPopupText(), is(equalTo("Sample menu")));
    }

    @Test
    @FileParameters("src/main/resources/testdata/swipe-minute-hand-to-list.csv")
    public void shouldSwipeMinuteHandTo(String from, String to) {
        Visitor visitor = VisitorPool.anonymous().openApp(DeviceType.ANDROID);
        AndroidHomePage homePage = (AndroidHomePage) visitor.nowLookingAt();
        ClockPage clockPage = homePage
                .openViews()
                .openDateWidgets()
                .openClock()
                .setClockAs(from, to);

        assertThat("Minute hand on the clock was set by mistake", clockPage.getSelectedMinuteFromClock(), is(equalTo(to)));
    }

    @Test
    public void shouldDragElementThenDrop() {
        Visitor visitor = VisitorPool.anonymous().openApp(DeviceType.ANDROID);
        AndroidHomePage homePage = (AndroidHomePage) visitor.nowLookingAt();
        DragAndDropPage dragAndDropPage = homePage
                .openViews()
                .openDragAndDrop()
                .dragElementThanDrop();

        assertThat("Drag then drop operation went by mistake", dragAndDropPage.getStatusMsg(), is(equalTo("Dropped!")));
    }

    @Test
    public void shouldWriteWiFiSettings() {
        String actualText = "Test Automation";

        Visitor visitor = VisitorPool.anonymous().openApp(DeviceType.ANDROID);
        AndroidHomePage homePage = (AndroidHomePage) visitor.nowLookingAt();
        PreferenceDependenciesPage preferenceDependenciesPage = homePage
                .openPreference()
                .openPreferenceDependencies()
                .setWifiCheckBox()
                .openWiFiSettingsPopup()
                .type(actualText)
                .OK()
                .openWiFiSettingsPopup();

        assertThat("WiFi settings text couldn't be written", preferenceDependenciesPage.getWrittenWiFiSettings(), is(equalTo(actualText)));
    }
}
