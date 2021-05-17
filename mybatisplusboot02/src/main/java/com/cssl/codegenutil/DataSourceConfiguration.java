package com.cssl.codegenutil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
//事务
@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration   {
    @Autowired
    DataSource dataSource;

    @Bean("transactionManager")
    public DataSourceTransactionManager jpaTransactionManager() {
        System.out.println("数据源："+dataSource);
        return new DataSourceTransactionManager(dataSource);
    }
}
