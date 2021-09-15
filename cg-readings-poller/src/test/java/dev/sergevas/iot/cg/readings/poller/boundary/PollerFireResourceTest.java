package dev.sergevas.iot.cg.readings.poller.boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PollerFireResourceTest {

    @Test
    public void testFirePollerEndpoint() {
        given()
          .when().post("/")
          .then()
             .statusCode(202);
    }
}
