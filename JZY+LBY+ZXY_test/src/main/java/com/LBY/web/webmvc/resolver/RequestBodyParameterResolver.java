package com.LBY.web.webmvc.resolver;

import com.LBY.web.webmvc.annotation.RequestBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.LBY.web.webmvc.entity.MethodDetail;
import java.lang.reflect.Parameter;


public class RequestBodyParameterResolver implements ParameterResolver {
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
    }

    @Override
    public Object resolve(MethodDetail methodDetail, Parameter parameter) {
        Object param = null;
        RequestBody requestBody = parameter.getDeclaredAnnotation(RequestBody.class);
        if (requestBody != null) {
            try {
                param = OBJECT_MAPPER.readValue(methodDetail.getJson(), parameter.getType());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return param;
    }
}
