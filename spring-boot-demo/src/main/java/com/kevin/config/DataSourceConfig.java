package com.kevin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by kevin on 16/11/22.
 */
@Configuration
// 扫描entity实体
@EntityScan(basePackages = "com.kevin.entity")
// 开启jpa
@EnableJpaRepositories(basePackages = "com.kevin.repository")
// 开启spring事物管理
@EnableTransactionManagement(proxyTargetClass = true)
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.initialSize}")
    private Integer initialSize;
    @Value("${spring.datasource.minIdle}")
    private Integer minIdle;
    @Value("${spring.datasource.maxActive}")
    private Integer maxActive;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private Integer timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private Integer maxOpenPreparedStatements;
    @Value("${spring.datasource.filters}")
    private String filters;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = null;
        try {
            dataSource = new DruidDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(username);//用户名
            dataSource.setPassword(password);//密码
            dataSource.setDriverClassName(driver);
            dataSource.setInitialSize(initialSize);
            dataSource.setMinIdle(minIdle);
            dataSource.setMaxActive(maxActive);
            dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
            dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
            dataSource.setValidationQuery(validationQuery);
            dataSource.setTestWhileIdle(testWhileIdle);
            dataSource.setTestOnBorrow(testOnBorrow);
            dataSource.setTestOnReturn(testOnReturn);
            dataSource.setPoolPreparedStatements(poolPreparedStatements);
            dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
