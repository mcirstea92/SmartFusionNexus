package ro.builditsmart.solutions.smartqhub.application;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class JaxFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        var oldRequestId = requestContext.getHeaderString("X-Request-ID");
        var requestId = MDCUtil.startRequestTrace(oldRequestId);
        responseContext.getHeaders().add("X-Request-ID", requestId);
    }
}
