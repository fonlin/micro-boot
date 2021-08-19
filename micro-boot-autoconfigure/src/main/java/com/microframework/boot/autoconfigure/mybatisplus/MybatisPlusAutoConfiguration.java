package com.microframework.boot.autoconfigure.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * mybatis-plus自动配置
 *
 * @author fonlin
 * @since 2020/12/21
 */
@Configuration
@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
@ConditionalOnSingleCandidate(DataSource.class)
@EnableConfigurationProperties(MybatisPlusProperties.class)
@AutoConfigureBefore(com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration.class)
public class MybatisPlusAutoConfiguration {


    /**
     * 通用字段的自动填充，因为增加
     *
     * @return  MetaObjectHandler
     */
    @Bean
    @ConditionalOnMissingBean
    public MetaObjectHandler metaObjectHandler() {
        return new DefaultMetaObjectHandler();
    }

    /**
     * 分页插件
     *
     * @return PaginationInterceptor
     */
    @Bean
    @ConditionalOnMissingBean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
         paginationInterceptor.setLimit(-1);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        // 指定数据库类型为mysql，提高分页查询效率
        paginationInterceptor.setDbType(DbType.MYSQL);
        return paginationInterceptor;
    }

    /**
     * 针对mybatis-plus做自动配置
     *
     * @return MybatisPlusPropertiesCustomizer
     */
    @Bean
    public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer() {
        return properties -> {
            // 获取mybatis-plus全局配置
            GlobalConfig globalConfig = properties.getGlobalConfig();
            // 关闭banner打印
            globalConfig.setBanner(false);

            // 获取数据库配置
            GlobalConfig.DbConfig dbConfig = globalConfig.getDbConfig();
            // 设置主键类型为自增
            dbConfig.setIdType(IdType.ASSIGN_UUID);

            // 获取MybatisConfiguration
            MybatisConfiguration configuration = properties.getConfiguration();
            if (configuration == null) {
                configuration = new MybatisConfiguration();
            }
            // 当结果集中值为 null 的时候是否调用映射对象的 Setter（Map 对象时为 put）方法
            // 因此此属性适用于Map来接收数据的情况
             configuration.setCallSettersOnNulls(true);
        };
    }

}
