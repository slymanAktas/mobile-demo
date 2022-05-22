package mobile;

import base.BaseTest;
import models.visitors.Visitor;
import models.visitors.VisitorPool;
import org.junit.Test;

public class ApiDemoTest extends BaseTest {

    @Test
    public void shouldTest(){

        Visitor visitor = VisitorPool.anonymous().openApp("android");
    }
}
