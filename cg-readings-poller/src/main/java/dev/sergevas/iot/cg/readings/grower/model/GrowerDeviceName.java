package dev.sergevas.iot.cg.readings.grower.model;

import java.util.Arrays;
import java.util.StringJoiner;

public enum GrowerDeviceName {

    GROWBAG_PEPPER_0001("0002", "Pepper Grow Bag 01");

    private String deviceId;
    private String deviceName;

    private GrowerDeviceName(String deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }

    public static GrowerDeviceName getByDeviceId(final String deviceIdStr) {
        return Arrays.stream(GrowerDeviceName.values())
                .filter(v -> v.deviceId.equals(deviceIdStr))
                .findAny()
                .orElse(null);
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GrowerDeviceName.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("deviceName='" + deviceName + "'")
                .toString();
    }
}
