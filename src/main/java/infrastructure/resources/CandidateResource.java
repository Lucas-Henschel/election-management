package infrastructure.resources;

import api.CandidateApi;
import api.dto.in.CreateCandidate;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/candidates")
public class CandidateResource {
  private final CandidateApi api;

  public CandidateResource(CandidateApi api) {
    this.api = api;
  }

  @POST
  @ResponseStatus(RestResponse.StatusCode.CREATED)
  @Transactional
  public void create(CreateCandidate dto) {
    api.create(dto);
  }
}
