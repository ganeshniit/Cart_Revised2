package com.amazon.cart1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.CategoryDAO;
import com.amazon.cart1.model.Category;

public class TestCaseCategory {

	
	 @Autowired
	 CategoryDAO categoryDAO;
		@Autowired
		Category category;
		AnnotationConfigApplicationContext context;
		@Before
		public void init(){
			context=new AnnotationConfigApplicationContext();
			context.scan("com.amazon");
			context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		category= (Category) context.getBean("category");
		}
	/*@Test
	public void deleteCategoryTest(){
		 category.setId("Electronics");
		 category.setName("Apple");
		 category.setDescription("Gadgets");
		//boolean flag =categoryDAO.delete(category);
		assertEquals("deleteCategoryTest",categoryDAO.delete(category),true);
		
	}
	//@Test
	/*public void addCategoryTest()

	{
		category.setId("CAT_002");
		category.setName("ELECTRONIC");
		category.setDescription("this is new iphone");
		
		assertEquals("addCategoryTest",categoryDAO.save(category),true);
		
	}*/
	/*@Test
	public void listCategoryTest(){
		
		assertEquals("listCategoryTest",categoryDAO.list().size(),3);
	}*/
	@Test
	public void updateCategoryTestCase(){
		category.setId("Category_1");
		category.setName("Men");
		category.setDescription("Clothing");
		assertEquals("updateCategoryTestCase",categoryDAO.update(category),true);
		
	}
	/*@Test
	public void getCategoryTestCase(){

	assertEquals("getCategoryTestCase",categoryDAO.get(category),true);
	assertEquals("getCategoryTestCase",categoryDAO.get("GAD"),category);
	assertEquals("getCategoryTestCase",categoryDAO.get("this is new iphone"),category);
	}*/
	

}
