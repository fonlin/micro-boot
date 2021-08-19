package com.microframework.boot.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

/**
 * 遍历树的好工具
 *
 * @author fonlin
 * @date 2021/4/1
 */
public class TreeTraversal {

    /**
     * 深度优先遍历，根节点会先进行一次consumer
     *
     * @param list  所有树节点
     * @param parent    开始遍历的父节点
     * @param childrenSupplier  查询子节点
     * @param consumer  遍历消费方法
     * @param <T>   节点泛型
     */
    public static <T> void depthFirst(List<T> list, T parent, ChildrenSupplier<T> childrenSupplier, Consumer<T> consumer) {
        consumer.accept(parent);
        List<T> children = childrenSupplier.get(list, parent);
        if (children != null && children.size() > 0) {
            for (T child : children) {
                depthFirst(list, child, childrenSupplier, consumer);
            }
        }
    }


    /**
     * 广度优先遍历
     *
     * @param list  所有树节点
     * @param rootNodeSupplier  获取根节点
     * @param childrenSupplier  查询子节点
     * @param consumer 消费方法
     * @param <T>   节点泛型
     */
    public <T> void breadthFirst(List<T> list, RootNodeSupplier<T> rootNodeSupplier, ChildrenSupplier<T> childrenSupplier, Consumer<T> consumer) {
        Deque<T> deque = new ArrayDeque<>();
        T root = rootNodeSupplier.get(list);
        deque.add(root);
        while (!deque.isEmpty()) {
            // 取出队列第一个
            T node = deque.peekFirst();
            // 消费
            consumer.accept(node);
            //获得节点的子节点，对于二叉树就是获得节点的左子结点和右子节点
            List<T> children = childrenSupplier.get(list, node);
            if (children != null && !children.isEmpty()) {
                deque.addAll(children);
            }
        }
    }

    public interface RootNodeSupplier<T> {

        T get(List<T> list);
    }

    public interface ChildrenSupplier<T> {

        List<T> get(List<T> list, T parent);
    }
}
