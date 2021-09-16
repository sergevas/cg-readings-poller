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
        return Collections.singletonMap("growlabv1-api/mp-rest/url", wireMockServer.baseUrl());
    }

    @Override
    public void stop() {
        Optional.ofNullable(this.wireMockServer).ifPresent(WireMockServer::stop);
    }
}
