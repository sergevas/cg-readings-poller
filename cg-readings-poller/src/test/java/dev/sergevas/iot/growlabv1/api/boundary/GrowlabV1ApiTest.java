package dev.sergevas.iot.growlabv1.api.boundary;

import dev.sergevas.iot.growlabv1.api.model.CameraModeType;
import dev.sergevas.iot.growlabv1.api.model.HealthCheckSchema;
import dev.sergevas.iot.growlabv1.api.model.HealthCheckSchemaChecks;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
    void getHealthChecks() {

        HealthCheckSchema healthCheck = growlabV1Api.getHealthChecks();

        assertNotNull(healthCheck);

        assertEquals("UP", healthCheck.getStatus());

        HealthCheckSchemaChecks deadlock = healthCheck.getChecks().stream()
                .filter(c -> "deadlock".equals(c.getName()))
                .findAny().orElse(null);
        assertNotNull(deadlock);
        assertEquals("UP", deadlock.getStatus());

        HealthCheckSchemaChecks diskSpace = healthCheck.getChecks().stream()
                .filter(c -> "diskSpace".equals(c.getName()))
                .findAny().orElse(null);
        assertNotNull(diskSpace);
        assertEquals("UP", diskSpace.getStatus());
        var diskSpaceData = diskSpace.getData();
        assertTrue(diskSpaceData instanceof Map);
        var diskSpaceDataMap = (Map)diskSpaceData;
        assertEquals("28.98 GB", diskSpaceDataMap.get("total"));
        assertEquals("62.99%", diskSpaceDataMap.get("percentFree"));
        assertEquals(BigDecimal.valueOf(31116636160L), diskSpaceDataMap.get("totalBytes"));
        assertEquals("18.25 GB", diskSpaceDataMap.get("free"));
        assertEquals(BigDecimal.valueOf(19598860288L), diskSpaceDataMap.get("freeBytes"));

        HealthCheckSchemaChecks heapMemory = healthCheck.getChecks().stream()
                .filter(c -> "heapMemory".equals(c.getName()))
                .findAny().orElse(null);
        assertNotNull(heapMemory);
        assertEquals("UP", heapMemory.getStatus());
        var heapMemorySpaceData = heapMemory.getData();
        assertTrue(heapMemorySpaceData instanceof Map);
        var heapMemorySpaceDataMap = (Map)heapMemorySpaceData;
        assertEquals("33.51 MB", heapMemorySpaceDataMap.get("total"));
        assertEquals("61.88 MB", heapMemorySpaceDataMap.get("max"));
        assertEquals("76.06%", heapMemorySpaceDataMap.get("percentFree"));
        assertEquals(BigDecimal.valueOf(35139584L), heapMemorySpaceDataMap.get("totalBytes"));
        assertEquals(BigDecimal.valueOf(64880640L), heapMemorySpaceDataMap.get("maxBytes"));
        assertEquals("18.70 MB", heapMemorySpaceDataMap.get("free"));
        assertEquals(BigDecimal.valueOf(19609080L), heapMemorySpaceDataMap.get("freeBytes"));

        HealthCheckSchemaChecks systemInfo = healthCheck.getChecks().stream()
                .filter(c -> "systemInfo".equals(c.getName()))
                .findAny().orElse(null);
        assertNotNull(systemInfo);
        assertEquals("UP", systemInfo.getStatus());
        var systemInfoData = systemInfo.getData();
        assertTrue(systemInfoData instanceof Map);
        var systemInfoDataMap = (Map)systemInfoData;
        assertEquals("46.54", systemInfoDataMap.get("cpuTemp"));
    }

    @Test
    void getImage() {
        File image = this.growlabV1Api.getImage();
        assertNotNull(image);
        byte[] binaryContent = null;
        try {
            binaryContent = Files.readAllBytes(image.toPath());
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        assertTrue(Arrays.equals(new byte[]{0, 1, 2, 3, 4, 5, 6, 7}, binaryContent));
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