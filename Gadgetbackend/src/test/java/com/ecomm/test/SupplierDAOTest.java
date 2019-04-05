package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Supplier;

public class SupplierDAOTest
{
static SupplierDAO supplierDAO;
		
		@BeforeClass
		public static void initialize()
		{
			@SuppressWarnings("resource")
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.ecomm");
			context.refresh();
			supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		}
		@Test
		public void addSupplierTest()
		{
			Supplier supplier=new Supplier();
			supplier.setSupplierName("Toshiba");
			supplier.setSupplierDesc("All Type of Laptops AvailAble");
			supplier.setAddress("HYdrebad");
			supplier.setCountry("India");
			supplier.setZonalCode(700245);
			assertNotNull("Adding the Supplier Details",supplierDAO.addSupplier(supplier));
		}
		@Ignore
		@Test
		public void updateSupplierTest()
		{
			Supplier supplier=supplierDAO.getSupplier(178);
			supplier.setSupplierName("Toshiba Company");
			assertTrue("Updating Supplier Details",supplierDAO.updateSupplier(supplier));
		}
		@Ignore
		@Test
		public void deleteSupplierTest()
		{
			Supplier supplier=supplierDAO.getSupplier(178);
			assertTrue("Updating Supplier Details",supplierDAO.deleteSupplier(supplier));
		}
		@Ignore
		@Test
		public void getSupplierTest()
		{
			Supplier supplier =supplierDAO.getSupplier(176);
			System.out.println("Supplier Id :"+supplier.getAddress());
			System.out.println("Supplier Country:"+supplier.getCountry());
			System.out.println("Supplier Description:"+supplier.getSupplierDesc());
		}
		@Ignore
		@Test
		public void ListProductsTest()
		{
			List<Supplier> listProducts=supplierDAO.listSuppliers();
			assertTrue("Problem in Retriveing the Supplier Details",listProducts.size()>0);
			System.out.println("**********Data Retrived from DdataBase********");
			for(Supplier supplier:listProducts)
			{
				System.out.print(supplier.getSupplierId()+" ::: ");
				System.out.print(supplier.getCountry()+" :::");
				System.out.println(supplier.getSupplierDesc());
			}
		}

}
