package org.example.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MybatisConfig
 * @Description TODO
 * @Date 2021/6/7 17:51
 * @Created by wangjianping
 */
@Configuration
@MapperScan({"org.example.springcloud.dao"})
public class MybatisConfig {
}
