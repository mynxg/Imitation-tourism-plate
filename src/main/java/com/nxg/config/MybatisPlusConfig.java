package com.nxg.config;

import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nxg
 * @apiNote 整合mybatis plus
 * 分页拦截器
 */
@Configuration
@MapperScan("com.nxg.dao")
public class MybatisPlusConfig {

    @Bean
    public PageInterceptor pageInterceptor(){
        return new PageInterceptor();
    }
}
