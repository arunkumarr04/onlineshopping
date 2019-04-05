package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest 
{
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
	}
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Hp");
		category.setCategoryDesc("All Laptops of Hp Brand");
		
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
	}
	
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category =categoryDAO.getCategory(2);
		assertTrue("Problem in Deleting Category class",categoryDAO.deleteCategory(category));
		System.out.println("Delete all data from DataBase");
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(1);
		category.setCategoryDesc("All laptops of Sony Brands");
		assertTrue("Problem adding UpdateCategory Class",categoryDAO.updateCategory(category));
	}
	@Ignore
	@Test
	public void ListCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		assertTrue("Problem in Retriveing the Category",listCategories.size()>0);
		System.out.println("**********Data Retrived from DdataBase********");
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+" ::: ");
			System.out.print(category.getCategoryName()+" :::");
			System.out.println(category.getCategoryDesc());
		}
	}
	@Ignore
	@Test
	public void getCategoryTest()
	{
		Category category =categoryDAO.getCategory(8);
		System.out.println("Category Id :"+category.getCategoryId());
		System.out.println("Category name:"+category.getCategoryName());
		System.out.println("Category Description:"+category.getCategoryDesc());
	}
	
	}
