package mobile;

import base.BaseTest;
import models.clients.DeviceType;
import models.pages.mobile.android.AndroidHomePage;
import models.pages.mobile.android.CustomAdapterPage;
import models.visitors.Visitor;
import models.visitors.VisitorPool;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
}
