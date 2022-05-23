package models.pages;

import models.clients.Device;
import models.clients.browsers.Browser;
import models.clients.phones.Phone;
import models.clients.phones.android.AndroidPhone;
import models.clients.phones.ios.ApplePhone;

public class Page {
    protected Device device;
    protected Browser browser;
    protected Phone phone;

    public void setDevice(Device device) {
        this.device = device;
        setDeviceAsItSupposeToBe();
    }

    private void setDeviceAsItSupposeToBe() {
        if (device instanceof Phone) {
            setPhoneAsItSupposeToBe();
        } else {
            this.browser = (Browser) this.device;
        }
    }

    private void setPhoneAsItSupposeToBe() {
        if (device instanceof AndroidPhone) {
            this.phone = (AndroidPhone) this.device;
        } else {
            this.phone = (ApplePhone) this.device;
        }
    }
}
