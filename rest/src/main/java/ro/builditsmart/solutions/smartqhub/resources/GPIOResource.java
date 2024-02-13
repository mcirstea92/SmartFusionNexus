package ro.builditsmart.solutions.smartqhub.resources;

import io.quarkiverse.jef.java.embedded.framework.linux.gpio.GpioPin;
import io.quarkiverse.jef.java.embedded.framework.runtime.gpio.GPIO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/gpio")
@Slf4j
public class GPIOResource {


    @GPIO(name = "pin0", number = 17)
    GpioPin pin17;

    @GET
    @Path("state")
    public Response getState() {
        return Response.ok(pin17.getName()).build();
    }
}
