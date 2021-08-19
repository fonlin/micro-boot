package com.microframework.boot.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.microframework.boot.entity.BaseEntity;

/**
 * @author fonlin
 * @date 2020/11/23
 */
public interface BaseService<T extends BaseEntity> extends BaseTimeService<T> {

}
