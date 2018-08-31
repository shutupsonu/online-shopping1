package com.nt.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.shoppingbackend.dao.ProductDAO;
import com.nt.shoppingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context ;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.nt.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("ProductDAO");
	}
	
	/*
	@Test
	public void testCURDProduct() {
		//create operation
		product = new Product();
		
		product.setName("Redmi Y71 Gold");
		product.setBrand("Redmi");
		product.setDescription("This is escriotion for Redmi mobile brand.");
		product.setUnitPrice(9999);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while inserting product.!",true,productDAO.add(product));
		*/
		//updating the product & deleting product
	/*	
		product = productDAO.get(2);
		product.setName("SAMSUNG galexy S7");
		assertEquals("Something went wrong while updating product.!",true,productDAO.update(product));
		
		assertEquals("Something went wrong while updating product.!",true,productDAO.delete(product));
	
		assertEquals("Something went wrong while updating product.!",7,productDAO.list().size());	
			
		}
		
		*/
		
		@Test
		public void testListOfActiveProduct() {
			assertEquals("Something went wrong while updating product.!",6,productDAO.listActiveProducts().size());
		}
		

		@Test
		public void testListOfActiveProductByCategory() {
			assertEquals("Something went wrong while updating product.!",4,productDAO.listActiveProductByCategory(3).size());
			assertEquals("Something went wrong while updating product.!",2,productDAO.listActiveProductByCategory(1).size());
		}
		
		@Test
		public void testlatestActiveProduct() {
			assertEquals("Something went wrong while updating product.!",4,productDAO.getLatestActiveProducts(4).size());
	
		}
		
		
}
