package ro.builditsmart.solutions.smartqhub.mapper;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.extern.slf4j.Slf4j;
import ro.builditsmart.solutions.smartqhub.models.exception.InvalidDTOPropertyException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class DTOEntityMapper<Entity extends PanacheEntityBase, DTO> {

    // TODO get security context here and get the username of the current logged in user
    // so that the lastUpdatedBy can be populated


    /**
     * Helper method to map DTO to entity
     *
     * @param dto    - the DTO object
     * @param entity - the entity it should map into
     */
    public void mapDtoToEntity(DTO dto, Entity entity) {
        try {
            Method[] methods = dto.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals("getLastUpdated")) {
                    Method entitySetter = findSetter(entity.getClass(), "LastUpdated", method.getReturnType());
                    entitySetter.invoke(entity, System.currentTimeMillis());
                    continue;
                }
                if (method.getName().equals("getLastUpdated")) {
                    Method entitySetter = findSetter(entity.getClass(), "LastUpdated", method.getReturnType());
                    //todo similarly for getLastUpdatedBy
                    var loggedInUsername = "admin";
                    entitySetter.invoke(entity, loggedInUsername);
                    continue;
                }
                if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
                    String propertyName = method.getName().substring(3);
                    Method entitySetter = findSetter(entity.getClass(), propertyName, method.getReturnType());
                    Object value = method.invoke(dto);
                    log.info("Found value {} for setter {}. DTO value: {}", value, entitySetter.getName(), dto);
                    if (value != null) {
                        entitySetter.invoke(entity, value);
                    }
                }

            }
        } catch (IllegalAccessException | InvocationTargetException | InvalidDTOPropertyException e) {
            throw new InvalidDTOPropertyException("Error mapping DTO to entity", e);
        }
    }

    /**
     * Helper method to find the corresponding setter method in the entity class
     *
     * @param clazz        - the class type
     * @param propertyName - the property name
     * @param propertyType - the property type
     */
    private Method findSetter(Class<?> clazz, String propertyName, Class<?> propertyType) {
        try {
            return clazz.getMethod("set" + propertyName, propertyType);
        } catch (NoSuchMethodException e) {
            log.error("Could not find setter for {} of type {} from class: {}", propertyName, propertyType, clazz);
            throw new InvalidDTOPropertyException("Error mapping DTO to entity", e);
        }
    }

}
