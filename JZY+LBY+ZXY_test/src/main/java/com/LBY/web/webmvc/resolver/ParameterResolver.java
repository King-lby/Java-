package com.LBY.web.webmvc.resolver;

import com.LBY.web.webmvc.entity.MethodDetail;

import java.lang.reflect.Parameter;


public interface ParameterResolver {

    Object resolve(MethodDetail methodDetail, Parameter parameter);

}
