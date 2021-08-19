package com.microframework.boot.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microframework.boot.entity.BaseEntity;
import com.microframework.boot.service.BaseService;

/**
 * @author fonlin
 * @date 2020/11/23
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends BaseTimeServiceImpl<M, T> implements BaseService<T> {

}
