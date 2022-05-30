package com.org.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;

@Configuration
@ComponentScan(basePackages = {"com.org.dunkey", "com.org.mapper", "com.org.domain", "com.org.service"})
/*
 * @ComponentScan(basePackages = {"org.dunkey.sample"})
 * 
 * @ComponentScan(basePackages = {"org.dunkey.task"})
 * 
 * @ComponentScan(basePackages = {"org.dunkey.controller", "org.dunkey.service",
 * "org.dunkey.aop"})
 * 
 * @MapperScan(basePackages = {"org.dunkey.mapper"})
 */
@MapperScan(basePackages = {"com.org.mapper"})
@Log4j

public class RootConfig {
	
	@Bean // 메소드의 실행 결과로 반환된 객체는 스프링 객체로 등록
	public DataSource dataSource() {
		log.info("DataSource-------------");
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:XE");
		hikariConfig.setUsername("scott");
		hikariConfig.setPassword("tiger");
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
