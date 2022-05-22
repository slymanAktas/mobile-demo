package models.visitors;

import base.TestContext;
import models.clients.Device;

import static models.clients.Device.openThe;

public class Visitor {
    private Device device;
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

    public Visitor openApp(String deviceName) {
        this.device = openThe(deviceName);
        return this;
    }
}
