package com.bdproject.pharmacy.config;

import com.bdproject.pharmacy.config.props.DataSourceProps;
import com.bdproject.pharmacy.config.props.FlywayProps;
import com.bdproject.pharmacy.config.props.HibernateProps;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {

    private final DataSourceProps dataSourceProps;
    private final FlywayProps flywayProps;
    private final HibernateProps hibernateProps;

    @Primary
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceProps.getUrl());
        dataSource.setUsername(dataSourceProps.getUsername());
        dataSource.setPassword(dataSourceProps.getPassword());
        dataSource.setDriverClassName(dataSourceProps.getDriverClassName());

        return dataSource;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        return Flyway.configure()
                .schemas(flywayProps.getSchemas())
                .locations(flywayProps.getLocations().toArray(new String[0]))
                .sqlMigrationPrefix("v")
                .sqlMigrationSeparator("__")
                .sqlMigrationSuffixes(".sql")
                .baselineVersion("1")
                .baselineDescription("<< Flyway Baseline >>")
                .baselineOnMigrate(true)
                .dataSource(dataSource())
                .outOfOrder(false)
                .baselineOnMigrate(true)
                .load();
    }

    @Bean
    @DependsOn("flyway")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);

        LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        managerFactoryBean.setDataSource(dataSource());
        managerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        managerFactoryBean.setPackagesToScan("com.bdproject.pharmacy");

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", hibernateProps.getDialect());
        properties.setProperty("hibernate.ddl-auto", hibernateProps.getDdlAuto());
        properties.setProperty("hibernate.show_sql", hibernateProps.getShowSql());
        managerFactoryBean.setJpaProperties(properties);

        return managerFactoryBean;
    }
}
