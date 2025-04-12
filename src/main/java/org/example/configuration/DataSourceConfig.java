package org.example.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
/*@EnableJpaRepositories(
        basePackages = {"org.example.dal", "org.example.model"},
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager")
@EnableTransactionManagement
@EntityScan(basePackages = {"org.example.dal", "org.example.model"})*/
public class DataSourceConfig {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DataSourceConfig.class);
    @Bean(name = "primaryDataSource")
    public DataSource dataSource() {

        try {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource.setUrl("jdbc:sqlserver://;serverName=fcc-db-server.database.windows.net;databaseName=fcc-db;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            dataSource.setUsername("fcc-admin@fcc-db-server");
            dataSource.setPassword("Akhil@123");
            logger.info("datasource created");
            return dataSource;
        } catch (Exception e) {
            logger.error("Error creating DataSource", e);
            throw new RuntimeException(e);
        }
        /*return DataSourceBuilder.create()
                .url("jdbc:sqlserver://fccdata.database.windows.net:1433;database=fcc-data-db;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;")
                .username("fccuser1@fccdata")
                .password("Fccdata@1")
                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .build();*/
    }
    /*@Bean(name = "primaryEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory(
            @Qualifier("primaryDataSource") DataSource primaryDataSource) {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        properties.setProperty(
                "jakarta.persistence.query.timeout", "" + 120000L);
        // TODO Only for UT

        // if( ("ut").equals(System.getProperty("runtime.context.environmentType")))
        properties.setProperty("hibernate.show_sql", "true");

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("org.example.dal");
        factory.setDataSource(primaryDataSource);
        factory.setJpaProperties(properties);
        factory.afterPropertiesSet();
        factory.setPersistenceUnitName("primaryEntityManagerFactory");

        return factory.getObject();
    }

    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager firstTransactionManager(
            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory firstEntityManagerFactory) {
        return new JpaTransactionManager(firstEntityManagerFactory);
    }*/
}