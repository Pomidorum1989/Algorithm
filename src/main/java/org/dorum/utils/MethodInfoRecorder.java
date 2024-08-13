package org.dorum.utils;

import java.lang.reflect.Method;
import java.util.*;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import static java.lang.reflect.Modifier.isStatic;

public class MethodInfoRecorder {

    public static Map<String, List<String>> recordMethodInfo(Class<?> clazz) {
        Map<String, List<String>> map = new HashMap<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(RecordMethodInfo.class) && isStatic(method.getModifiers())) {
                RecordMethodInfo annotation = method.getAnnotation(RecordMethodInfo.class);
                String methodName = method.getName();
                map.put(methodName, Arrays.asList(String.valueOf(getLineNumber(method)), annotation.link()));
            }
        }
        return map;
    }

    public static int getLineNumber(Method method) {
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass cc = pool.get(method.getDeclaringClass().getCanonicalName());
            CtMethod javassistMethod = cc.getDeclaredMethod(method.getName());
            return javassistMethod.getMethodInfo().getLineNumber(0);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
