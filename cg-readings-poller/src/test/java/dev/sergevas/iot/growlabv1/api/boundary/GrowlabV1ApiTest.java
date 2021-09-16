package dev.sergevas.iot.growlabv1.api.boundary;

import dev.sergevas.iot.growlabv1.api.model.CameraModeType;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
@QuarkusTestResource(WiremockGrowlabV1Api.class)
class GrowlabV1ApiTest {

    @Inject
    @RestClient
    GrowlabV1Api growlabV1Api;

    @Test
    void getCameraMode() {
        CameraModeType cameraModeType = growlabV1Api.getCameraMode();
        assertNotNull(cameraModeType);
        assertEquals(CameraModeType.ModeEnum.NORM, cameraModeType.getMode());
        assertEquals(OffsetDateTime.parse("2021-09-16T11:01:33.837497Z"), cameraModeType.getModeTimestamp());
    }

    @Test
    @Disabled
    void getHealthChecks() {
    }

    @Test
    @Disabled
    void getImage() {
    }

    @Test
    @Disabled
    void getLightIntensity() {
    }

    @Test
    @Disabled
    void getThp() {
    }

    @Test
    @Disabled
    void putCameraMode() {
    }
}