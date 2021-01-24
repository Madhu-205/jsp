package com.madhu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.madhu.beans.Student;
import com.madhu.dao.StudentDao;

public class Test {

	public static void main(String[] args)throws Exception {
          ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
          StudentDao dao=(StudentDao)context.getBean("studentDao");
           String status=dao.delete("S-111");
           System.out.println("Student Record Deleted :"+status);
          
          

	}

}
