package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTest 
{

	static ProductDAO productDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		
		context.refresh();
		
		productDAO=(ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Lenevo Laptops");
		product.setProductDesc("All laptops of lenevo brand");
		product.setStock(20);
		assertTrue("Problem Loading Add Product Test",productDAO.addProduct(product));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(10);
		assertTrue("Problem in loading Delete Product",productDAO.deleteProduct(product));
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(11);
		product.setProductDesc("All laptops of lenevo brand");
		assertTrue("Problem adding UpdateCategory Class",productDAO.updateProduct(product));
	}
	@Ignore
	@Test
	public void ListProductsTest()
	{
		List<Product> listProducts=productDAO.listProducts();
		assertTrue("Problem in Retriveing the Products",listProducts.size()>0);
		System.out.println("**********Data Retrived from DdataBase********");
		for(Product product:listProducts)
		{
			System.out.print(product.getCategoryId()+":::");
			System.out.print(product.getProductDesc()+":::");
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.print(product.getStock()+":::");
			System.out.println(product.getSupplierId());
		}
	}
	@Ignore
	@Test
	public void getProductTest()
	{
		Product product =productDAO.getProduct(11);
		System.out.println("Productc category Id :"+product.getCategoryId());
		System.out.println("Product Description:"+product.getProductDesc());
		System.out.println("Product Name:"+product.getProductName());
		System.out.println("Product Stock:"+product.getStock());
	
	}

}