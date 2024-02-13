package ro.builditsmart.solutions.smartqhub.resources;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import ro.builditsmart.solutions.smartqhub.mapper.DTOEntityMapper;

import java.lang.reflect.InvocationTargetException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public abstract class BaseResource<E extends PanacheEntityBase, D, R extends PanacheRepositoryBase<E, Long>> {

    private final Class<E> entityClass;
    private final DTOEntityMapper<E, D> mapper;

    private final R repository;


    public BaseResource(Class<E> entityClass, R repository) {
        this.entityClass = entityClass;
        this.mapper = new DTOEntityMapper<>();
        this.repository = repository;
    }

    @GET
    public Response getAllEntities() {
        return Response.ok(repository.findAll().list()).build();
    }

    @GET
    @Path("/{id}")
    public Response getEntityById(@PathParam("id") Long id) {
        E entity = repository.findById(id);
        return entity != null ? Response.ok(entity).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Transactional
    public Response createEntity(D dto) {
        try {
            E entity = entityClass.getDeclaredConstructor().newInstance();
            mapper.mapDtoToEntity(dto, entity);
            entity.persist();
            return Response.status(Response.Status.CREATED).build();
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateEntity(@PathParam("id") Long id, D dto) {
        E entity = repository.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        log.info("old entity: {}", entity);
        mapper.mapDtoToEntity(dto, entity);
        log.info("new entity: {}", entity);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        var deleted = repository.deleteById(id);
        return deleted ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}