package com.microframework.boot.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 *
 * @author fonlin
 * @date 2020/10/28
 */
public class PageUtil {

    /**
     * 对list进行分页
     *
     * @param list      list
     * @param pageIndex 当前页数，从1开始
     * @param pageSize  每页条数
     * @param <T>       泛型
     * @return          分页结果
     */
    public static  <T> List<T> page(List<T> list, int pageIndex, int pageSize) {
        //总记录数
        int total = list.size();
        //覆盖区左侧坐标
        int leftIndex = (pageIndex - 1) * pageSize;
        //用于检查是否被覆盖到
        boolean covered = (total - leftIndex) > 0;
        //覆盖区右侧坐标
        int rightIndex = pageIndex * pageSize;
        //如果没有被覆盖到，返回空数组
        if (!covered) {
            return new ArrayList<>();
        } else {
            //如果覆盖区在total内
            if (rightIndex <= total) {
                return list.subList(leftIndex, rightIndex);
            } else {
                return list.subList(leftIndex, total);
            }
        }
    }
}
