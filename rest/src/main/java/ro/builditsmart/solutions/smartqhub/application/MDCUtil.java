package ro.builditsmart.solutions.smartqhub.application;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.UUID;

@Slf4j
public class MDCUtil {

    private static final String X_REQ_ID = "X-Request-ID";

    public static String startRequestTrace(String oldRequestId) {
        if (oldRequestId == null) {
            oldRequestId = UUID.randomUUID().toString();
        }
        log.info("Got a server request. RequestId: {}", oldRequestId);
        MDC.put(X_REQ_ID, oldRequestId);
        return oldRequestId;
    }

    public static void endRequestTrace() {
        MDC.remove(X_REQ_ID);
    }

    public static String getCurrentRequestId() {
        return MDC.get(X_REQ_ID);
    }

}
