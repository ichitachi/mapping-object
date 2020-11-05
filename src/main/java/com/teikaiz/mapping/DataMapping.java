package com.teikaiz.mapping;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.stream.Stream;

public class DataMapping {

    public static void mapping(final Object from, final Object to) {
        Stream.of(to.getClass().getDeclaredFields())
                .forEach(toField -> {
                    try {
                        FieldMapping annotation = toField.getAnnotation(FieldMapping.class);
                        Field fromField  = getField(annotation, from, toField);
                        if(Objects.isNull(annotation) || (Objects.nonNull(annotation) && !annotation.ignore())){
                            fromField.setAccessible(true);
                            toField.setAccessible(true);
                            Object value = fromField.get(from);
                            toField.set(to, value);
                        }
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    private static Field getField(FieldMapping annotation,  Object from, Field toField) throws NoSuchFieldException {
        try {
            return from.getClass().getDeclaredField(toField.getName());
        }catch (NoSuchFieldException ex) {
            return from.getClass().getDeclaredField(annotation.name());
        }
    }
}
