package dev.sergevas.iot.cg.readings.grower.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@RegisterForReflection
public class GrowerDeviceRequest {

    private OffsetDateTime date;
    private String deviceId;
    private String deviceLabel;
    private Double soilTemp;
    private Double soilMoisture;
    private String pumpStat;

    public GrowerDeviceRequest(OffsetDateTime date, String deviceId, Double soilTemp, Double soilMoisture, String pumpStat) {
        this.date = date;
        this.deviceId = deviceId;
        this.deviceLabel = GrowerDeviceLabel.getByDeviceId(deviceId).getDeviceLabel();
        this.soilTemp = soilTemp;
        this.soilMoisture = soilMoisture;
        this.pumpStat = pumpStat;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceLabel() {
        return deviceLabel;
    }

    public Double getSoilTemp() {
        return soilTemp;
    }

    public Double getSoilMoisture() {
        return soilMoisture;
    }

    public String getPumpStat() {
        return pumpStat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrowerDeviceRequest that = (GrowerDeviceRequest) o;
        return Objects.equals(date, that.date) && Objects.equals(deviceId, that.deviceId) && Objects.equals(deviceLabel, that.deviceLabel) && Objects.equals(soilTemp, that.soilTemp) && Objects.equals(soilMoisture, that.soilMoisture) && Objects.equals(pumpStat, that.pumpStat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, deviceId, deviceLabel, soilTemp, soilMoisture, pumpStat);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GrowerDeviceRequest.class.getSimpleName() + "[", "]")
                .add("date=" + date)
                .add("deviceId='" + deviceId + "'")
                .add("deviceLabel='" + deviceLabel + "'")
                .add("soilTemp=" + soilTemp)
                .add("soilMoisture=" + soilMoisture)
                .add("pumpStat='" + pumpStat + "'")
                .toString();
    }
}
