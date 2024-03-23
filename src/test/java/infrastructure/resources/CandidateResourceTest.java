package infrastructure.resources;

import api.CandidateApi;
import api.dto.in.CreateCandidate;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.instancio.Instancio;
import org.jboss.resteasy.reactive.RestResponse;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(CandidateResource.class)
class CandidateResourceTest {
  @InjectMock
  CandidateApi api;

  @Test
  void create() {
    var in = Instancio.create(CreateCandidate.class);

    given().contentType(MediaType.APPLICATION_JSON).body(in)
      .when().post()
      .then().statusCode(RestResponse.StatusCode.CREATED);

    verify(api).create(in);
    verifyNoMoreInteractions(api);
  }
}