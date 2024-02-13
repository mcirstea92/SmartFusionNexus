package ro.builditsmart.solutions.smartqhub.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import ro.builditsmart.solutions.smartqhub.entities.LightingEntity;
import ro.builditsmart.solutions.smartqhub.models.lighting.LightingDTO;
import ro.builditsmart.solutions.smartqhub.repositories.LightingRepository;

@Path("lighting")
@Slf4j
public class LightingResource extends BaseResource<LightingEntity, LightingDTO, LightingRepository> {

    private final LightingRepository repository;

    public LightingResource(LightingRepository repository) {
        super(LightingEntity.class, repository);
        this.repository = repository;
    }

    @GET
    @Path("/pin/{pin}")
    public Response getLightInfoByPhysicalPin(@PathParam("pin") Integer pin) {
        var found = repository.find("raspberryPin", pin).firstResult();
        return found != null ? Response.ok(found).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/bcm/{pin}")
    public Response getLightInfoByBCMPin(@PathParam("pin") Integer pin) {
        var found = repository.find("bcmPin", pin).firstResult();
        return found != null ? Response.ok(found).build() : Response.status(Response.Status.NOT_FOUND).build();
    }


    @GET
    @Path("/wiringPi/{pin}")
    public Response getLightInfoByWiringPiPin(@PathParam("pin") Integer pin) {
        var found = repository.find("wiringPi", pin).firstResult();
        return found != null ? Response.ok(found).build() : Response.status(Response.Status.NOT_FOUND).build();
    }


}

