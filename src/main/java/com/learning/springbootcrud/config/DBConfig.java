//package com.learning.springbootcrud.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//
//import java.util.Properties;
//
//@Configuration
//@ComponentScan("com.learning.*")
//public class DBConfig {
//    @Bean
//    public DriverManagerDataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUsername("sc_su");
//        dataSource.setPassword("123456");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/springboot_crud");
//
//        return dataSource;
//    }
//
//    @Bean(name="entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactoryBean(DriverManagerDataSource dataSource) {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setPackagesToScan("com.learning.*");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }
//
//    @Bean
//    public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory.getObject());
//        return transactionManager;
//    }
//
//    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        return properties;
//    }
//}
