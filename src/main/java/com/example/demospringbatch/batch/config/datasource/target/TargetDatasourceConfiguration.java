package com.example.demospringbatch.batch.config.datasource.target;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TargetDatasourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.target")
    public DataSourceProperties targetDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    public DataSource targetDataSource() {
        return targetDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
}
