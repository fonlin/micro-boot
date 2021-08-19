package com.microframework.boot.util;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * Bean转换工具类
 *
 * @author fonlin
 * @date 2021-03-01
 **/
public class BeanConverter {

    /**
     * 将源对象深拷贝至目标class对象
     *
     * @param source      源对象
     * @param targetClass 目标对象Class
     * @param <S>         源对象泛型
     * @param <T>         目标对象泛型
     * @return 目标对象
     */
    public static <S, T> T convert(S source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        try {
            T target = targetClass.newInstance();
            return convert(source, target);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将源对象深拷贝至目标class对象
     *
     * @param source           源对象
     * @param targetClass      目标对象Class
     * @param ignoreProperties 在拷贝时忽略的字段属性
     * @param <S>              源对象泛型
     * @param <T>              目标对象泛型
     * @return 目标对象
     */
    public static <S, T> T convert(S source, Class<T> targetClass, String... ignoreProperties) {
        if (source == null) {
            return null;
        }
        try {
            T target = targetClass.newInstance();
            return convert(source, target, ignoreProperties);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将源对象集合深拷贝至目标class对象集合
     *
     * @param sources     源对象集合
     * @param targetClass 目标对象Class
     * @param <S>         源对象泛型
     * @param <T>         目标对象泛型
     * @return 目标对象集合
     */
    public static <S, T> List<T> convert(List<S> sources, Class<T> targetClass) {
        if (sources == null) {
            return null;
        }
        return sources.stream().map(s -> convert(s, targetClass)).collect(Collectors.toList());
    }

    /**
     * 将源对象集合深拷贝至目标class对象集合
     *
     * @param sources          源对象集合
     * @param targetClass      目标对象Class
     * @param ignoreProperties 在拷贝时忽略的字段属性
     * @param <S>              源对象泛型
     * @param <T>              目标对象泛型
     * @return 目标对象集合
     */
    public static <S, T> List<T> convert(List<S> sources, Class<T> targetClass, String... ignoreProperties) {
        if (sources == null) {
            return null;
        }
        return sources.stream().map(s -> convert(s, targetClass, ignoreProperties)).collect(Collectors.toList());
    }

    /**
     * 将源对象深拷贝至目标对象
     *
     * @param source 源对象
     * @param target 目标对象
     * @param <S>    源对象泛型
     * @param <T>    目标对象泛型
     * @return 目标对象
     */
    public static <S, T> T convert(S source, T target) {
        if (source == null) {
            return null;
        }
        copyProperties(source, target);
        return target;
    }

    /**
     * 将源对象深拷贝至目标对象
     *
     * @param source           源对象
     * @param target           目标对象
     * @param ignoreProperties 在拷贝时忽略的字段属性
     * @param <S>              源对象泛型
     * @param <T>目标对象泛型
     * @return 目标对象
     */
    public static <S, T> T convert(S source, T target, String... ignoreProperties) {
        if (source == null) {
            return null;
        }
        copyProperties(source, target, ignoreProperties);
        return target;
    }
}
