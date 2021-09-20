package dev.sergevas.iot.cg.readings.event.entity.model;

import org.junit.jupiter.api.Test;

import javax.json.bind.JsonbBuilder;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BaseEventTest {

    @Test
    void testSerialize() {
        BaseEvent baseEvent = new BaseEvent()
                .withEventId("07aa54a8-4833-4408-8161-8a908830423b")
                .withCreatedAt(OffsetDateTime.now())
                .withReadAt(OffsetDateTime.now())
                .withDeviceId("growlab-v1-device_id")
                .withDevcieName("growlab-v1-device_name")
                .withTopic("cg/growlab-v1-device_id/tmp");
        String jsonSerialized = JsonbBuilder.create().toJson(baseEvent);
        assertNotNull(jsonSerialized);
    }
}
