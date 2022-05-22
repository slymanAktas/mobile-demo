package models.clients;

public enum DeviceType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    ANDROIDAPP("android"),
    IOSAPP("ios");

    private String name;

    DeviceType(String name) {
        this.name = name;
    }

    public static DeviceType byName(String defaultBrowserName) {
        DeviceType found = null;

        for (DeviceType type : values()) {
            if (type.is(defaultBrowserName)) {
                found = type;
                break;
            }
        }

        if (found == null) {
            throw new IllegalArgumentException("Illegal Browser: " + defaultBrowserName);
        }

        return found;
    }

    public boolean is(String defaultBrowserName) {
        String lowerCasedTypeName = name.toLowerCase();
        String lowerCasedDefaultName = defaultBrowserName.toLowerCase();
        return lowerCasedTypeName.equals(lowerCasedDefaultName);
    }
}
