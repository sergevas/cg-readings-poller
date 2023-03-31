package dev.sergevas.iot.cg.readings.event.controller;

import dev.sergevas.iot.cg.readings.event.model.DataItem;
import dev.sergevas.iot.cg.readings.event.model.ReadingsEvent;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.function.Function;

public class ReadingsEventBuilder {

    private String sensorType;
    private String measurementUnit;
    private String eventId;
    private String deviceId;
    private String deviceName;
    private String natsSubject;
    private OffsetDateTime createdAt;
    private OffsetDateTime readAt;
    private Object data;

    public ReadingsEventBuilder sensorType(String sensorType) {
        this.sensorType = sensorType;
        return this;
    }

    public ReadingsEventBuilder measurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
        return this;
    }

    public ReadingsEventBuilder eventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    public ReadingsEventBuilder deviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public ReadingsEventBuilder deviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    public ReadingsEventBuilder natsSubject(String natsSubject) {
        this.natsSubject = natsSubject;
        return this;
    }

    public ReadingsEventBuilder createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ReadingsEventBuilder readAt(OffsetDateTime readAt) {
        this.readAt = readAt;
        return this;
    }

    public ReadingsEventBuilder data(Object data) {
        this.data = data;
        return this;
    }

    public <T> ReadingsEvent build(Function<Object, T> transformer) {
        ReadingsEvent readingsEvent = new ReadingsEvent();
        readingsEvent.setEventId(eventId);
        readingsEvent.setDeviceId(deviceId);
        readingsEvent.setDeviceName(deviceName);
        readingsEvent.setTopic(natsSubject);
        readingsEvent.setCreatedAt(createdAt);
        readingsEvent.setReadAt(readAt);
        readingsEvent.setData(new DataItem()
                .withType(sensorType)
                .withUnit(measurementUnit)
                .withValue(Optional
                        .ofNullable(data)
                        .map(transformer)
                        .orElse(null)));
        return readingsEvent;
    }
}
