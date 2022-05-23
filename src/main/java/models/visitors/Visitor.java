package models.visitors;

import base.TestContext;
import models.clients.Device;
import models.clients.DeviceType;
import models.clients.browsers.Browser;
import models.clients.phones.Phone;
import models.pages.Page;
import models.pages.mobile.android.AndroidHomePage;

import static models.clients.Device.openThe;

public class Visitor {
    private Device device;
    private Phone phone;
    private Browser browser;
    private String email;
    private String password;
    private String userName;
    private boolean isOnline;
    private TestContext testContext;

    public Visitor(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Device device() {
        return device;
    }

    public void closeDevice() {
        device.close();
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public Device getDevice() {
        return device;
    }

    public TestContext getTestContext() {
        return testContext;
    }

    public void setTestContext(TestContext testContext) {
        this.testContext = testContext;
    }

    private void setDeviceAsItSupposeToBe() {
        if (device instanceof Phone) {
            this.phone = (Phone) this.device;
        } else {
            this.browser = (Browser) this.device;
        }
    }

    public Visitor openApp(DeviceType deviceType) {
        this.device = openThe(deviceType.name());
        setDeviceAsItSupposeToBe();
        this.device.setPage(new AndroidHomePage());
        return this;
    }

    public Page nowLookingAt() {
        return this.device.page();
    }
}
