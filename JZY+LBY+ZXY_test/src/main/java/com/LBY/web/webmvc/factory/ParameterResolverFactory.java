package com.LBY.web.webmvc.factory;

import com.LBY.web.webmvc.annotation.PathVariable;
import com.LBY.web.webmvc.annotation.RequestBody;
import com.LBY.web.webmvc.annotation.RequestParam;
import com.LBY.web.webmvc.resolver.PathVariableParameterResolver;
import com.LBY.web.webmvc.resolver.RequestBodyParameterResolver;
import com.LBY.web.webmvc.resolver.RequestParamParameterResolver;
import com.LBY.web.webmvc.resolver.ParameterResolver;

import java.lang.reflect.Parameter;

/**
 * 参数解析器 类似于策略转发
 */
public class ParameterResolverFactory {

    public static ParameterResolver get(Parameter parameter) {
        if (parameter.isAnnotationPresent(RequestParam.class)) {
            return new RequestParamParameterResolver();
        }
        if (parameter.isAnnotationPresent(PathVariable.class)) {
            return new PathVariableParameterResolver();
        }
        if (parameter.isAnnotationPresent(RequestBody.class)) {
            return new RequestBodyParameterResolver();
        }
        return null;
    }
}
