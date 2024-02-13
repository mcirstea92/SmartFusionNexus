package ro.builditsmart.solutions.smartqhub.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("hi")
@Produces(MediaType.APPLICATION_JSON)
public class HelloEndpoint {

    @Path("hello")
    @GET
    public String hello() {
        return "{\"message\": \"Hello, world\"}";
    }

}
