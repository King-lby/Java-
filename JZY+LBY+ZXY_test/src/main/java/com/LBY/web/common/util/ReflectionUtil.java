package com.LBY.web.common.util;

import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;


public class ReflectionUtil {

    public static Set<Class<?>> scanAnnotatedClass(String packageName, Class<? extends Annotation> annotation) {
        //这边实现是根据人家的api实现的，如果自己要实现，那么就要递归遍历文件，然后判断每一个.class结尾的文件，再找到那个注解
        Reflections reflections = new Reflections(packageName, new TypeAnnotationsScanner());
        Set<Class<?>> annotatedClass = reflections.getTypesAnnotatedWith(annotation, true);
        return annotatedClass;
    }


    public static <T> Set<Class<? extends T>> getSubClass(String packageName, Class<T> interfaceClass) {
        Reflections reflections = new Reflections(packageName);
        return reflections.getSubTypesOf(interfaceClass);

    }


    public static Object newInstance(Class<?> cls) {
        Object instance = null;
        try {
            instance = cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
        }
        return instance;
    }


    public static void setField(Object obj, Field field, Object value) {

        field.setAccessible(true);
        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static Object executeTargetMethod(Object targetObject, Method method, Object... args) throws Exception {
        Object result;
        try {
            // invoke target method through reflection
            result = method.invoke(targetObject, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new Exception(e.toString());
        }
        return result;
    }

}
