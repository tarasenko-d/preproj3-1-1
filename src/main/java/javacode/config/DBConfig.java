package javacode.config;

import javacode.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
public class DBConfig {


    private static SessionFactory sessionFactory;

    private static final String hibernate_show_sql = "false";
    private static final String hibernate_connection_username = "test";
    private static final String hibernate_connection_password = "test";
    private static final String hibernate_connection_url = "jdbc:h2:./h2db";
    private static final String hibernate_hbm2ddl_auto = "update";

    @Bean
    public Configuration getH2Configuration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", hibernate_connection_url);
        configuration.setProperty("hibernate.connection.username", hibernate_connection_username);
        configuration.setProperty("hibernate.connection.password", hibernate_connection_password);
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);

        return configuration;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("javacode");
        factory.setDataSource(getDataSource());
        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());

        return factory.getObject();
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl(hibernate_connection_url);
        dataSource.setUsername(hibernate_connection_username);
        dataSource.setPassword(hibernate_connection_password);

        return dataSource;
    }
}

