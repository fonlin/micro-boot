package com.microframework.boot.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

/**
 * 带时间的实体继承，用于需要创建时间、更新时间的场景
 *
 * @author fonlin
 * @date 2020/11/26
 */
public class BaseTimeEntity {

    @TableField(fill = FieldFill.INSERT)
    private Date creationTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date lastModifiedTime;

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}
