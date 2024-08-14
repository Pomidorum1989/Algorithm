package org.dorum.utils;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.lang.reflect.Method;
import java.util.*;

import static java.lang.reflect.Modifier.isStatic;

public class MethodInfoRecorder {

    public static Map<String, List<String>> recordMethodInfo(Class<?> clazz) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(RecordMethodInfo.class) && isStatic(method.getModifiers())) {
                RecordMethodInfo annotation = method.getAnnotation(RecordMethodInfo.class);
                String methodName = method.getName();
                map.put(methodName, Arrays.asList(String.valueOf(getLineNumber(method)), annotation.link()));
            }
        }
        return map;
    }

    private static int getLineNumber(Method method) {
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
