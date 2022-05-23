package models.pages;

import models.clients.Device;
import models.clients.browsers.Browser;
import models.clients.phones.Phone;

public class Page {
    protected Device device;
    protected Browser browser;
    protected Phone phone;

    public void setDevice(Device device){
        this.device = device;
        setDeviceAsItSupposeToBe();
    }

    private void setDeviceAsItSupposeToBe() {
        if (device instanceof Phone) {
            this.phone = (Phone) this.device;
        } else {
            this.browser = (Browser) this.device;
        }
    }
}
