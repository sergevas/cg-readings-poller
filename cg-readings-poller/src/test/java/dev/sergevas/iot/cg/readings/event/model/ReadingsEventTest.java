package dev.sergevas.iot.cg.readings.event.model;

import org.junit.jupiter.api.Test;

import javax.json.bind.JsonbBuilder;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReadingsEventTest {

    @Test
    void testSerialize() {
        ReadingsEvent lightEvent = new ReadingsEvent();
        lightEvent.setEventId("07aa54a8-4833-4408-8161-8a908830423b");
        lightEvent.setCreatedAt(OffsetDateTime.now());
        lightEvent.setReadAt(OffsetDateTime.now());
        lightEvent.setDeviceId("growlab-v1-device_id");
        lightEvent.setDeviceName("growlab-v1-device_name");
        lightEvent.setTopic("cg/growlab-v1-device_id/tmp");
        lightEvent.setData(new DataItem().withUnit("lx").withValue(Double.valueOf(48745.67)));
        String jsonSerialized = JsonbBuilder.create().toJson(lightEvent);
        assertNotNull(jsonSerialized);
    }
}
