package com.rec.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ApplicationConfiguration {

	// H2 config
	private static final Class<org.h2.Driver> DRIVER = org.h2.Driver.class;
	private static final Class<org.hibernate.dialect.H2Dialect> DIALECT = org.hibernate.dialect.H2Dialect.class;
	private static final Database DB = Database.H2;
	private static final String URL = "jdbc:h2:~/alpha_db";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	// mysql config
	// private static final Class<com.mysql.jdbc.Driver> DRIVER =
	// com.mysql.jdbc.Driver.class;
	// private static final Class<org.hibernate.dialect.MySQL5Dialect> DIALECT =
	// org.hibernate.dialect.MySQL5Dialect.class;
	// private static final Database DB = Database.MYSQL;
	// private static final String URL = "";
	// private static final String USER = "";
	// private static final String PASSWORD = "";

	@Bean(name = "jspViewResolver")
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		ir.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		ir.setPrefix("WEB-INF/views/");
		ir.setSuffix(".jsp");
		return ir;
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(DRIVER.getName());
		ds.setUrl(URL);
		ds.setUsername(USER);
		ds.setPassword(PASSWORD);
		return ds;

	}

	@Bean
	public Map<String, Object> jpaProperties() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.dialect", DIALECT.getName());
		props.put("hibernate.hbm2ddl.auto", "create-drop");
		return props;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter ha = new HibernateJpaVendorAdapter();
		ha.setShowSql(true);
		ha.setGenerateDdl(true);
		ha.setDatabase(DB);
		return ha;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lf = new LocalContainerEntityManagerFactoryBean();
		lf.setDataSource(this.dataSource());
		lf.setJpaPropertyMap(this.jpaProperties());
		lf.setJpaVendorAdapter(this.jpaVendorAdapter());
		return lf;
	}

}
