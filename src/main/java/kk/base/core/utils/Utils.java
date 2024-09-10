package kk.base.core.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Utils {

    public static boolean isEmpty(Object obj) {
        if (obj == null) return true;
        if (obj instanceof String) {
            return ((String) obj).trim().isEmpty();
        } else if (obj instanceof List<?>) {
            return ((List<?>) obj).isEmpty();
        } else if (obj instanceof Map<?, ?>) {
            return ((Map<?, ?>) obj).isEmpty();
        }
        return false;
    }

    public static <E, D> D mapToDto(E entity, Class<D> dtoClass) {
        try {
            D dto = dtoClass.getDeclaredConstructor().newInstance();
            for (Field entityField : entity.getClass().getDeclaredFields()) {
                entityField.setAccessible(true);
                try {
                    Field dtoField;
                    if("id".equals(entityField.getName())) {
                        dtoField = dtoClass.getSuperclass().getDeclaredField("id");
                    } else {
                        dtoField = dtoClass.getDeclaredField(entityField.getName());
                    }
                    dtoField.setAccessible(true);
                    dtoField.set(dto, entityField.get(entity));
                } catch (NoSuchFieldException e) {
                    // If the field doesn't exist in DTO, continue to the next field
                    continue;
                }
            }
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping entity to DTO", e);
        }
    }

    public static <D, E> E mapToEntity(D dto, Class<E> entityClass) {
        try {
            E entity = entityClass.getDeclaredConstructor().newInstance();
            for (Field dtoField : dto.getClass().getDeclaredFields()) {
                dtoField.setAccessible(true);
                try {
                    Field entityField = entityClass.getDeclaredField(dtoField.getName());
                    entityField.setAccessible(true);
                    entityField.set(entity, dtoField.get(dto));
                } catch (NoSuchFieldException e) {
                    // If the field doesn't exist in Entity, continue to the next field
                    continue;
                }
            }
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping DTO to entity", e);
        }
    }
}
