package com.microframework.boot.autoconfigure.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.microframework.boot.entity.BaseEntity;
import com.microframework.boot.entity.BaseTimeEntity;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.util.ClassUtils;

import java.util.Date;


/**
 * MyBatisPlus对于公用字段的填充
 *
 * @author fonlin
 */
public class DefaultMetaObjectHandler implements MetaObjectHandler {

    private final boolean IS_SPRING_SECURITY_ENVIRONMENT = ClassUtils.isPresent("org.springframework.security.core.context.SecurityContextHolder", null);


    @Override
    public void insertFill(MetaObject metaObject) {
        // 如果是继承BaseEntity
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            Date date = new Date();
            this.setFieldValByName("creationTime", date, metaObject);
            this.setFieldValByName("lastModifiedTime", date, metaObject);
            this.setFieldValByName("isDel", 0, metaObject);
            // 判断是否是spring security环境
            if (IS_SPRING_SECURITY_ENVIRONMENT) {
                // TODO 设置创建人等信息
                /*if (!SpringSecurityUtil.isGuest()) {
                    CurrentUser user = SpringSecurityUtil.getUser();
                    this.setFieldValByName("createUser", user.getId(), metaObject);
                    this.setFieldValByName("createUserName", user.getName(), metaObject);
                    this.setFieldValByName("lastModifiedUser", user.getId(), metaObject);
                    this.setFieldValByName("lastModifiedUserName", user.getName(), metaObject);
                }*/
            }
        } else if (metaObject.getOriginalObject() instanceof BaseTimeEntity) {
            // 如果是继承BaseTimeEntity，设置创建时间、更新时间
            Date date = new Date();
            this.setFieldValByName("creationTime", date, metaObject);
            this.setFieldValByName("lastModifiedTime", date, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 如果是继承BaseEntity
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            Date date = new Date();
            this.setFieldValByName("lastModifiedTime", date, metaObject);
            // 判断是否是spring security环境
            if (IS_SPRING_SECURITY_ENVIRONMENT) {
                // TODO 设置更新人等信息
                /*if (!SpringSecurityUtil.isGuest()) {
                    CurrentUser user = SpringSecurityUtil.getUser();
                    this.setFieldValByName("lastModifiedUser", user.getId(), metaObject);
                    this.setFieldValByName("lastModifiedUserName", user.getName(), metaObject);
                }*/
            }
        } else if (metaObject.getOriginalObject() instanceof BaseTimeEntity) {
            // 如果是继承BaseTimeEntity，设置更新时间
            Date date = new Date();
            this.setFieldValByName("lastModifiedTime", date, metaObject);
        }
    }
}