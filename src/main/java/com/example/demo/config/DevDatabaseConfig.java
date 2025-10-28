package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

@Configuration
@ConditionalOnMissingBean(DataSource.class)
public class DevDatabaseConfig {

    @Bean
    public DataSource dataSource() {
        // Start a PostgreSQL container dynamically
        PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16")
                .withDatabaseName("demo")
                .withUsername("user")
                .withPassword("pass");

        postgres.start();

        // Create a DataSource using the container’s connection info
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(postgres.getJdbcUrl());
        ds.setUsername(postgres.getUsername());
        ds.setPassword(postgres.getPassword());

        System.out.println("✅ Testcontainer started at " + postgres.getJdbcUrl());
        return ds;
    }
}
