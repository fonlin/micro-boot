package com.microframework.boot.util;

/**
 * 代码执行时间工具类
 *
 * 继承{@link org.springframework.util.StopWatch}实现静态方法创建
 *
 * @author fonlin
 * @date 2021/4/26
 */
public class StopWatch extends org.springframework.util.StopWatch {


    public static StopWatch createStarted() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }

    public static StopWatch createUnStarted() {
        return new StopWatch();
    }
}
