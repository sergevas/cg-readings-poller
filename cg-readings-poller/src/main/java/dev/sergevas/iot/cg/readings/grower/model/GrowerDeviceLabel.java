package dev.sergevas.iot.cg.readings.grower.model;

import java.util.Arrays;
import java.util.StringJoiner;

public enum GrowerDeviceLabel {

    GROWBAG_PEPPER_0001("0001", "Pepper Grow Bag 01");

    private String deviceId;
    private String deviceLabel;

    private GrowerDeviceLabel(String deviceId, String deviceLabel) {
        this.deviceId = deviceId;
        this.deviceLabel = deviceLabel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceLabel() {
        return deviceLabel;
    }

    public static GrowerDeviceLabel getByDeviceId(final String deviceIdStr) {
        return Arrays.stream(GrowerDeviceLabel.values())
                .filter(v -> v.deviceId.equals(deviceIdStr))
                .findAny()
                .orElse(null);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GrowerDeviceLabel.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("deviceLabel='" + deviceLabel + "'")
                .toString();
    }
}
