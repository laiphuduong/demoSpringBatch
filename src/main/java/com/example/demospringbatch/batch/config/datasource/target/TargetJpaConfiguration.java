package com.example.demospringbatch.batch.config.datasource.target;

import javax.sql.DataSource;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.demospringbatch.target",
        entityManagerFactoryRef = "targetEntityManagerFactory",
        transactionManagerRef = "targetTransactionManager"
)
public class TargetJpaConfiguration {
    @Bean
    public LocalContainerEntityManagerFactoryBean targetEntityManagerFactory(
            @Qualifier("targetDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.demospringbatch.target")
                .build();
    }

    @Bean
    public PlatformTransactionManager targetTransactionManager(
            @Qualifier("targetEntityManagerFactory") LocalContainerEntityManagerFactoryBean targetEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(targetEntityManagerFactory.getObject()));
    }
}
