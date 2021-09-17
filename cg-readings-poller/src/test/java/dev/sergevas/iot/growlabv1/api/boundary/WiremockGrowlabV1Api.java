package dev.sergevas.iot.growlabv1.api.boundary;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WiremockGrowlabV1Api implements QuarkusTestResourceLifecycleManager {

    private WireMockServer wireMockServer;

    @Override
    public Map<String, String> start() {
        wireMockServer = new WireMockServer();
        wireMockServer.start();

        stubFor(get(urlEqualTo("/actuators/camera/mode"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "    \"mode\": \"NORM\",\n" +
                                "    \"mode_timestamp\": \"2021-09-16T11:01:33.837497Z\"\n" +
                                "}")
                        .withStatus(200)));

        stubFor(get(urlEqualTo("/health"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "    \"outcome\": \"UP\",\n" +
                                "    \"status\": \"UP\",\n" +
                                "    \"checks\": [\n" +
                                "        {\n" +
                                "            \"name\": \"deadlock\",\n" +
                                "            \"state\": \"UP\",\n" +
                                "            \"status\": \"UP\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"name\": \"diskSpace\",\n" +
                                "            \"state\": \"UP\",\n" +
                                "            \"status\": \"UP\",\n" +
                                "            \"data\": {\n" +
                                "                \"free\": \"18.25 GB\",\n" +
                                "                \"freeBytes\": 19598860288,\n" +
                                "                \"percentFree\": \"62.99%\",\n" +
                                "                \"total\": \"28.98 GB\",\n" +
                                "                \"totalBytes\": 31116636160\n" +
                                "            }\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"name\": \"heapMemory\",\n" +
                                "            \"state\": \"UP\",\n" +
                                "            \"status\": \"UP\",\n" +
                                "            \"data\": {\n" +
                                "                \"free\": \"18.70 MB\",\n" +
                                "                \"freeBytes\": 19609080,\n" +
                                "                \"max\": \"61.88 MB\",\n" +
                                "                \"maxBytes\": 64880640,\n" +
                                "                \"percentFree\": \"76.06%\",\n" +
                                "                \"total\": \"33.51 MB\",\n" +
                                "                \"totalBytes\": 35139584\n" +
                                "            }\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"name\": \"systemInfo\",\n" +
                                "            \"state\": \"UP\",\n" +
                                "            \"status\": \"UP\",\n" +
                                "            \"data\": {\n" +
                                "                \"cpuTemp\": \"46.54\"\n" +
                                "            }\n" +
                                "        }\n" +
                                "    ]\n" +
                                "}")
                        .withStatus(200)));

        stubFor(get(urlEqualTo("/actuators/camera/image"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/octet-stream")
                        .withBody(new byte[]{0, 1, 2, 3, 4, 5, 6, 7})
                        .withStatus(200)));

        stubFor(get(urlEqualTo("/sensors/light"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "    \"s_id\": null,\n" +
                                "    \"s_type\": \"LIGHT\",\n" +
                                "    \"s_data\": \"680.83\",\n" +
                                "    \"s_timestamp\": \"2021-09-17T07:33:47.280603Z\"\n" +
                                "}")
                        .withStatus(200)));

        stubFor(get(urlEqualTo("/sensors/thp"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "    \"s_readings\": [\n" +
                                "        {\n" +
                                "            \"s_id\": \"60\",\n" +
                                "            \"s_type\": \"TEMP\",\n" +
                                "            \"s_data\": \"20.152979624649742\",\n" +
                                "            \"s_timestamp\": \"2021-09-17T07:42:57.919122Z\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"s_id\": \"60\",\n" +
                                "            \"s_type\": \"HUMID\",\n" +
                                "            \"s_data\": \"46.3402342737451\",\n" +
                                "            \"s_timestamp\": \"2021-09-17T07:42:57.919122Z\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"s_id\": \"60\",\n" +
                                "            \"s_type\": \"PRESS\",\n" +
                                "            \"s_data\": \"100017.3369229056\",\n" +
                                "            \"s_timestamp\": \"2021-09-17T07:42:57.919122Z\"\n" +
                                "        }\n" +
                                "    ]\n" +
                                "}")
                        .withStatus(200)));

        stubFor(put(urlEqualTo("/actuators/camera/mode"))
                .withHeader("Content-Type", containing("application/json"))
                .withRequestBody(containing("{\"mode\":\"NORM\"}"))
                .willReturn(aResponse()
                        .withStatus(200)));

        return Collections.singletonMap("growlabv1-api/mp-rest/url", wireMockServer.baseUrl());
    }

    @Override
    public void stop() {
        Optional.ofNullable(this.wireMockServer).ifPresent(WireMockServer::stop);
    }
}
