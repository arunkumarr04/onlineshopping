package com.ecomm.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;
import com.ecomm.model.Userdetail;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.gadget")

public class DBConfig 
{
	@Bean(name="DataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
	    datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
     	datasource.setUsername("sa");
		datasource.setPassword("arun123");
		
		System.out.println("==DataSource object Created==");
		return datasource;
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	    LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
	    factory.addProperties(hibernateProp);
	    factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(Userdetail.class);
		factory.addAnnotatedClass(Product.class);
	    SessionFactory sessionFactory=factory.buildSessionFactory();
	    System.out.println("====SessionFactory Object Created====");
	    return sessionFactory;
	}
	
	@Bean(name="txManager")
	
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Creating the TransactionManager Bean");
		return new HibernateTransactionManager(sessionFactory);
	}
}
	    

