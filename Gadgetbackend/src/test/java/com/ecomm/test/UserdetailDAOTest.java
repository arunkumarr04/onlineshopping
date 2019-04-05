package com.ecomm.test;


import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserdetailDAO;
import com.ecomm.model.Userdetail;

public class UserdetailDAOTest 
{
	static UserdetailDAO userdetailDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		userdetailDAO=(UserdetailDAO)context.getBean("userdetailDao");
	}	
	
	@Test
	public void addUserdetailTest()
	{
		Userdetail userdetail=new Userdetail();
		userdetail.setAddress("Chennai");
		userdetail.setCustomerName("Arunkumar");
		userdetail.setEnable(true);
		userdetail.setPassword("pass@123");
		userdetail.setRole("User");
		userdetail.setUserName("Arun");
	
		assertTrue("Problem adding userdetail",userdetailDAO.addUserdetail(userdetail));
	}
	@Ignore
	@Test
	public void updateUserdetailTest()
	{
		Userdetail userdetail=userdetailDAO.getUserdetail("arunkwelz04@gmail.com");
		userdetail.setPassword("9940660542");
		assertTrue("Problem in Updating User Detail",userdetailDAO.updateUserdetail(userdetail));
	}
	
	@Ignore
	@Test
	public void getUserdetailTest()
	{
		Userdetail userdetail=userdetailDAO.getUserdetail("arun04");
		System.out.println("User Name:"+userdetail.getUserName());
		System.out.println("Password:"+userdetail.getPassword());
		System.out.println("Customer Name"+userdetail.getUserName());
		System.out.println("Customer Address:"+userdetail.getCustomerName());
	}
	
	}

