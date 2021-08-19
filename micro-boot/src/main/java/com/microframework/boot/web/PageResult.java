package com.microframework.boot.web;

import java.util.List;

/**
 * @author fonlin
 * @date 2020/5/27
 */
public class PageResult<T> {

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 当前页数据集
     */
    private List<T> records;

    /**
     * 额外数据
     */
    private Object data;

    public PageResult() {
    }

    public PageResult(Long total, List<T> records) {
        this(total, records, null);
    }

    public PageResult(Long total, List<T> records, Object data) {
        this.total = total;
        this.records = records;
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static <T> PageResultBuilder<T> builder() {
        return new PageResultBuilder<T>();
    }

    public static class PageResultBuilder<T> {
        private Long total;

        private List<T> records;

        private Object data;

        PageResultBuilder() {
        }

        public PageResultBuilder<T> total(final Long total) {
            this.total = total;
            return this;
        }

        public PageResultBuilder<T> records(final List<T> records) {
            this.records = records;
            return this;
        }

        public PageResultBuilder<T> data(final Object data) {
            this.data = data;
            return this;
        }

        public PageResult<T> build() {
            return new PageResult<T>(this.total, this.records, this.data);
        }
    }
}
