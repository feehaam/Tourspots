package com.feeham.playground.utils;

import com.feeham.playground.exceptions.CustomException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public interface MapExtractor {
    @SuppressWarnings("unchecked")
    public default  <T> T read(Map<String, Object> mappedObject, String key, Class<T> expectedClass,
                                          String errorMessage) {
        Object object = mappedObject.getOrDefault(key, null);
        if (object == null) {
            throw new CustomException(errorMessage, HttpStatus.BAD_REQUEST);
        }
        if (!expectedClass.isInstance(object)) {
            return null;
        }
        return (T) object;
    }

//    @SuppressWarnings("unchecked")
//    public default <T> T read(Map<String, Object> mappedObject, String key, Class<T> expectedClass) {
//        Object object = mappedObject.getOrDefault(key, null);
//        return (T) object;
//    }
}
