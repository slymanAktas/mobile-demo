package models.clients;

import models.clients.browsers.chrome.Chrome;
import models.clients.browsers.firefox.Firefox;
import models.clients.phones.android.AndroidPhone;
import models.clients.phones.ios.ApplePhone;

public class Devices {

    private Devices() {}

    public static Device run(DeviceType deviceType) {
        Device device;
        switch (deviceType) {
            case CHROME:
                device = new Chrome();
                break;
            case FIREFOX:
                device = new Firefox();
                break;
            case IOSAPP:
                device = new ApplePhone();
                break;
            default: //Default is Android
                device = new AndroidPhone();
                break;
        }
        return device;
    }

    public static Device getDevice(String deviceName){
        return run(DeviceType.byName(deviceName));
    }
}
