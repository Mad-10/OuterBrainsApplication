package com.outerbrains.service.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.outerbrains.user", "com.outerbrains.file",
        "com.outerbrains.team", "com.outerbrains.score", "com.outerbrains.chat", "com.outerbrains.task", "com.outerbrains.project"})
@MapperScan(basePackages = {"com.outerbrains.chat.mapper", "com.outerbrains.file.mapper",
        "com.outerbrains.project.mapper", "com.outerbrains.score.mapper", "com.outerbrains.task.mapper",
        "com.outerbrains.team.mapper", "com.outerbrains.user.mapper"}) // 扫描Mapper接口
public class ApplicationServiceConfiguration {

    private DataSource dataSource;
    ApplicationServiceConfiguration() {
        this.dataSource = DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/outerbrains")
                .username("root")
                .password("root0@OuterBrains")
                .build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        // 配置SqlSessionFactory
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // 配置事务管理器
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
