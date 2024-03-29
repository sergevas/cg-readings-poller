package dev.sergevas.iot.cg.readings.event.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.config.PropertyOrderStrategy;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;


/**
 * BaseEvent
 * <p>
 * Represents an IoT device base domain event for communication support between components of the system
 */

@RegisterForReflection
@JsonbPropertyOrder(PropertyOrderStrategy.LEXICOGRAPHICAL)
public class BaseEvent implements Serializable {

    private final static long serialVersionUID = 375403980422462297L;

    /**
     * The event unique id
     * (Required)
     */
    @JsonbProperty("event_id")
    @NotNull
    private String eventId;
    /**
     * The event creation timestamp
     * (Required)
     */
    @JsonbProperty("created_at")
    @NotNull
    private OffsetDateTime createdAt;
    /**
     * The device data reading timestamp
     * (Required)
     */
    @JsonbProperty("read_at")
    @NotNull
    private OffsetDateTime readAt;
    /**
     * The unique id of the IoT device
     */
    @JsonbProperty("device_id")
    private String deviceId;
    /**
     * Device name
     */
    @JsonbProperty("device_name")
    private String deviceName;
    /**
     * Device type
     */
    @JsonbProperty("device_type")
    private String deviceType;
    /**
     * The event publish topic name
     */
    @JsonbProperty("topic")
    private String topic;

    /**
     * The event unique id
     * (Required)
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * The event unique id
     * (Required)
     */
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public BaseEvent withEventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    /**
     * The event creation timestamp
     * (Required)
     */
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * The event creation timestamp
     * (Required)
     */
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BaseEvent withCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The device data reading timestamp
     * (Required)
     */
    public OffsetDateTime getReadAt() {
        return readAt;
    }

    /**
     * The device data reading timestamp
     * (Required)
     */
    public void setReadAt(OffsetDateTime readAt) {
        this.readAt = readAt;
    }

    public BaseEvent withReadAt(OffsetDateTime readAt) {
        this.readAt = readAt;
        return this;
    }

    /**
     * The unique id of the IoT device
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * The unique id of the IoT device
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public BaseEvent withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    /**
     * Device name
     */
    public String getdeviceName() {
        return deviceName;
    }

    /**
     * Device name
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public BaseEvent withDeviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    /**
     * Device name
     */
    public String getdeviceType() {
        return deviceType;
    }

    /**
     * Device name
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public BaseEvent withDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    /**
     * The event publish topic name
     */
    public String getTopic() {
        return topic;
    }

    /**
     * The event publish topic name
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public BaseEvent withTopic(String topic) {
        this.topic = topic;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEvent baseEvent = (BaseEvent) o;
        return Objects.equals(eventId, baseEvent.eventId) && Objects.equals(createdAt, baseEvent.createdAt)
                && Objects.equals(readAt, baseEvent.readAt) && Objects.equals(deviceId, baseEvent.deviceId)
                && Objects.equals(deviceName, baseEvent.deviceName) && Objects.equals(deviceType, baseEvent.deviceType)
                && Objects.equals(topic, baseEvent.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, createdAt, readAt, deviceId, deviceName, deviceType, topic);
    }

    @Override
    public String toString() {
        return "BaseEvent{" +
                "eventId='" + eventId + '\'' +
                ", createdAt=" + createdAt +
                ", readAt=" + readAt +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
