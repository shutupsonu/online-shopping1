package com.nt.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.shoppingbackend.dao.CategoryDAO;
import com.nt.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.nt.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	  @Test public void testAddCategory() { category = new Category();
	  category.setName("Telivison");
	  category.setDescription("This is Telivison description..");
	  category.setImageURL("CAT_3.png");
	  
	  assertEquals("succcessfully addedd category inside table", true,categoryDAO.add(category));
	  
	  }
	 */
	
	/*
	  @Test public void testGetCategory() {
	  
	  category = categoryDAO.get(3);
	  assertEquals("succcessfull fetched single category from table", "watch",category.getName()); }
	 */

	/*
	  @Test 
	  public void updateCategory() { 
	  category = categoryDAO.get(2);
	  category.setName("TV");
	  assertEquals("succcessfull updated  single category into table", true,categoryDAO.update(category));
  
	  }
	*/ 
/*
	@Test
	public void deleteCategory() {
		category = categoryDAO.get(2);
		assertEquals("succcessfull delete single category into table", true, categoryDAO.delete(category));
	}
	*/
	
	/*
	@Test
	public void testListCategory() {
		
		assertEquals("succcessfully fetched categories from the table", 3, categoryDAO.list().size());
	}
	*/
		@Test
		public void testCURDCategory() {
		/*	
			//add category into table
			category = new Category();
			category.setName("Laptop");
			category.setDescription("This is Laptop description..");
			category.setImageURL("CAT_1.png");
			
			assertEquals("succcessfull addedd category inside table", true,categoryDAO.add(category));
			
			category = new Category();
			category.setName("Mobile");
			category.setDescription("This is Mobile description..");
			category.setImageURL("CAT_2.png");
			
			assertEquals("succcessfull addedd category inside table", true,categoryDAO.add(category));  
		
			category = new Category();
			category.setName("Televison");
			category.setDescription("This is Televison description..");
			category.setImageURL("CAT_3.png");
			
			assertEquals("succcessfull addedd category inside table", true,categoryDAO.add(category));
		*/	
			//fetching and updating the category
			category= categoryDAO.get(3);
			category.setName("TV");
			assertEquals("succcessfull updated  single category into table", true,categoryDAO.update(category));
			
			//delete the category
			assertEquals("succcessfull delete single category into table", true, categoryDAO.delete(category));
			
			//Fetching list
			assertEquals("succcessfully fetched categories from the table", 2 , categoryDAO.list().size());
		}

}

