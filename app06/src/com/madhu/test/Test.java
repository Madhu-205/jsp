package com.madhu.test;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.madhu.bean.Employee;
import com.madhu.dao.EmployeeDao;

public class Test {

	public static void main(String[] args)throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao dao =(EmployeeDao)context.getBean("employeeDao");
		Map<String, Object> map =dao.getAllEmployees();
		System.out.println(map);
		ArrayList<Employee> list=(ArrayList<Employee>)map.get("emps");
		System.out.println(list);
		
		System.out.println("Employee Details");
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("--------------------");
		for (Employee e:list) {
			System.out.println(e.getEno()+"\t"+e.getEname()+"\t"+e.getEsal()+"\t"+e.getEaddr());
		}
	}

}
