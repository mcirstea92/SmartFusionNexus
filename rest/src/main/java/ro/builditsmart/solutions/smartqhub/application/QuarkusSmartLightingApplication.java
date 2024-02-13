package ro.builditsmart.solutions.smartqhub.application;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.ConfigProvider;

@ApplicationPath("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class QuarkusSmartLightingApplication extends Application {

    @PostConstruct
    public void afterInit() {
        log.info("Application started");
    }

    private static final boolean ALLOW_DELETE = ConfigProvider.getConfig().getOptionalValue("stockanalyzer.allow.delete", Boolean.class).orElse(true);

    public static boolean isDeleteForbidden() {
        return !ALLOW_DELETE;
    }

}
