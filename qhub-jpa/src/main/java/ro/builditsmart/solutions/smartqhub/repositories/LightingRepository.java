package ro.builditsmart.solutions.smartqhub.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.builditsmart.solutions.smartqhub.entities.LightingEntity;

@ApplicationScoped
public class LightingRepository implements PanacheRepository<LightingEntity> {

    private static final Logger log = LoggerFactory.getLogger(LightingRepository.class);

    @PostConstruct
    public void afterInit() {
        log.info("After lighting repository init: --> listAll -> {}", this.listAll());
    }

}