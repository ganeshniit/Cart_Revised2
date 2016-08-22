package com.amazon.cart1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.UserDetailsDAO;
import com.amazon.cart1.model.UserDetails;

public class TestCaseUserDetails {

	 @Autowired
	 UserDetailsDAO UserDetailsDAO;
		@Autowired
		UserDetails UserDetails;
		AnnotationConfigApplicationContext context;
		@Before
		public void init(){
			context=new AnnotationConfigApplicationContext();
			context.scan("com.amazon.cart1");
			context.refresh();
		UserDetailsDAO=(UserDetailsDAO) context.getBean("UserDetailsDAO");
		UserDetails= (UserDetails) context.getBean("UserDetails");
		}
	@Test
	public void deleteUserDetailsTest(){
		 UserDetails.setId("User_22");
		 UserDetails.setName("Ganesh");
		 UserDetails.setEmail("vemuriganeshg@gmail.com");
		 UserDetails.setPassword("ganeshv");
		 UserDetails.setContact("8185956671");
		 UserDetails.setAddress("Hyderabad");
		boolean flag =UserDetailsDAO.delete(UserDetails);
		assertEquals("deleteUserDetailsTest",flag,true);
		
	}
	@Test
	public void addUserDetailsTest()

	{
		 UserDetails.setId("User_23");
		 UserDetails.setName("Sai");
		 UserDetails.setEmail("nitish@gmail.com");
		 UserDetails.setPassword("nitishv");
		 UserDetails.setContact("8185956671");
		 UserDetails.setAddress("Hyderabad");
		//UserDetails.setDescription("this is new iphone");
		
		assertEquals("addUserDetailsTest",UserDetailsDAO.save(UserDetails),true);
		
	}
	@Test
	public void listUserDetailsTest(){
		assertEquals("listUserDetailsTest",UserDetailsDAO.list().size(),1);
	}
	@Test
	public void updateUserDetailsTestCase(){
		 UserDetails.setId("User_23");
		 UserDetails.setName("Sainitish");
		 UserDetails.setEmail("nitish@gmail.com");
		 UserDetails.setPassword("nitishv");
		 UserDetails.setContact("8185956671");
		 UserDetails.setAddress("Hyderabad");
		//UserDetails.setDescription("this is new iphone");
		assertEquals("updateUserDetailsTestCase",UserDetailsDAO.update(UserDetails),true);
		
	}
	/*@Test
	public void getUserDetailsTestCase(){

	assertEquals("getUserDetailsTestCase",UserDetailsDAO.get("User_23"),UserDetails);
	
	}*/
	

}
