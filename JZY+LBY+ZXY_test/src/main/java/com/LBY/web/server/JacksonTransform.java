package com.LBY.web.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * 因为我们Netty传输到时候是二进制，所以需要转换对象
 */
public class JacksonTransform {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public byte[] serialize(Object object) {
        byte[] bytes = new byte[0];
        try {
            // Java object to JSON string, default compact-print
            bytes = objectMapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        T object = null;
        try {
            object = objectMapper.readValue(bytes, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }
}
