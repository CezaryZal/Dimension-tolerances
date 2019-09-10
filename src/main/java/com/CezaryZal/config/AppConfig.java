package com.CezaryZal.config;

//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
//@EnableTransactionManagement
@ComponentScan("com.CezaryZal")
//@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
        registry.addResourceHandler("/style/**")
                .addResourceLocations("/resources/style/");
        registry.addResourceHandler("/graphics/**")
                .addResourceLocations("/resources/graphics/");

    }

//    @Bean
//    public LocalSessionFactoryBean sessionFactory(){
//
//        // create session factory
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        // set the properties
//        sessionFactory.setDataSource(dataSource());
////        sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
////        sessionFactory.setHibernateProperties(getHibernateProperties());
//
//        return sessionFactory;
//    }
//
//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager (SessionFactory sessionFactory){
//
//        // set transaction manager based on session factory
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory);
//
//        return transactionManager;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//
//        // create connection pool
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//
//        // set the jdbc driver
//        try {
//            dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
//            System.out.println("wewnątrz dataSource");
//        }
//        catch (PropertyVetoException error) {
//            throw new RuntimeException(error);
//        }
//
//        //log the connection props
//        //just to make sure we are REALLY reading data from properties file
//        logger.info("jdbc.url=" + environment.getProperty("jdbc.url"));
//        logger.info("jdbc.user=" + environment.getProperty("jdbc.user"));
//
//        // set database connection props
//        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
//        dataSource.setUser(environment.getProperty("jdbc.user"));
//        dataSource.setPassword(environment.getProperty("jdbc.password"));
//
//        // set connection pool props
//        dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
//        dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
//        dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
//        dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
//
//        return dataSource;
//    }
//
//    //helper method - read environment property and convert to int
//    private int getIntProperty (String propName){
//        String propVal = environment.getProperty(propName);
//        int intPropVal = Integer.parseInt(propVal);
//
//        return intPropVal;
//    }

//    private Properties getHibernateProperties() {
//
//        // set hibernate properties
//        Properties props = new Properties();
//
//        props.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//        props.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//
//        return props;
//    }


}
