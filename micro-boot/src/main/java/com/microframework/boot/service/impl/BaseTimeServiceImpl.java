package com.microframework.boot.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microframework.boot.entity.BaseTimeEntity;
import com.microframework.boot.service.BaseTimeService;

/**
 * @author fonlin
 * @date 2020/11/23
 */
public class BaseTimeServiceImpl<M extends BaseMapper<T>, T extends BaseTimeEntity> extends ServiceImpl<M, T> implements BaseTimeService<T> {

}
