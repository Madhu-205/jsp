package com.madhu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.madhu.dao.TransactionDao;

public class Test {

	public static void main(String[] args)throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		TransactionDao dao= (TransactionDao) context.getBean("transactionDao");
		String status=dao.transforFunds("abc123", "xyz123", 5000);
		System.out.println(status);
		
	}

}
