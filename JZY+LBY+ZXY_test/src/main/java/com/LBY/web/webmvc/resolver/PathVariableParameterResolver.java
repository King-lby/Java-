package com.LBY.web.webmvc.resolver;

import com.LBY.web.common.util.ObjectUtil;
import com.LBY.web.webmvc.annotation.PathVariable;
import com.LBY.web.webmvc.entity.MethodDetail;

import java.lang.reflect.Parameter;
import java.util.Map;


public class PathVariableParameterResolver implements ParameterResolver {
    @Override
    public Object resolve(MethodDetail methodDetail, Parameter parameter) {
        PathVariable pathVariable = parameter.getDeclaredAnnotation(PathVariable.class);
        String requestParameter = pathVariable.value();
        Map<String, String> urlParameterMappings = methodDetail.getUrlParameterMappings();
        String requestParameterValue = urlParameterMappings.get(requestParameter);
        return ObjectUtil.convert(parameter.getType(), requestParameterValue);
    }
}

