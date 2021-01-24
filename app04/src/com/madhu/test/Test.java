package com.madhu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.madhu.bean.Customer;
import com.madhu.dao.CustomerDao;

public class Test {

	public static void main(String[] args)throws Exception {
		ApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerDao dao =(CustomerDao)context.getBean("customerDao");
	
   Customer csd1= new Customer();
   String status=dao.delete("C-111");
   System.out.println("Customer Record Deleted :"+status);
		
		
		
	}

}
