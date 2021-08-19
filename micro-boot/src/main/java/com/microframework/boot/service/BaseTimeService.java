package com.microframework.boot.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.microframework.boot.entity.BaseTimeEntity;

/**
 * @author fonlin
 * @since 2021/1/14
 */
public interface BaseTimeService<T extends BaseTimeEntity> extends IService<T> {

}
