package com.madhu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.madhu.bean.Student;
import com.madhu.dao.StudentDao;

public class Test {

	public static void main(String[] args)throws Exception {
       
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao)context.getBean("studentDao");
		
	Student std = new Student();
	std.setSid("s-222");
	std.setSname("zzz");
	std.setSaddr("uuu");
	String status=dao.update(std);
	System.out.println("Student Updation :"+status);
	System.out.println();
	
	status=dao.delete("s-111");
	System.out.println("Student Record Deleted :"+status);
	}

}
