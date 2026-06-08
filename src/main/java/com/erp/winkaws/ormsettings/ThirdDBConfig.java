package com.erp.winkaws.ormsettings;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.erp.winkaws.mydb", entityManagerFactoryRef = "thirdEntityManagerFactory", transactionManagerRef = "thirdTransactionManager")
public class ThirdDBConfig {

	@Bean(name = "thirdDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.third")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "thirdEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("thirdDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.erp.winkaws.mydb").persistenceUnit("third")
				.properties(Map.of("hibernate.hbm2ddl.auto", "update", "hibernate.dialect",
						"org.hibernate.dialect.SQLServerDialect", "hibernate.physical_naming_strategy",
						"org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl"))
				.build();
	}

	@Bean(name = "thirdTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("thirdEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
