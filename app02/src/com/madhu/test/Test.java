package com.madhu.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.madhu.dao.EmployeeDao;
import com.madhu.dto.Employee;

public class Test {

	public static void main(String[] args)throws Exception {
		ApplicationContext context =new ClassPathXmlApplicationContext("/com/madhu/resources/applicationContext.xml");
		EmployeeDao dao=(EmployeeDao)context.getBean("employeeDao");
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1. add Employee");
			System.out.println("2. search Employee");
			System.out.println("3.  Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5.  Exit");
			System.out.print("your option[1,2,3,4,5]   :");
			int option =Integer.parseInt(br.readLine());
			Employee emp=null;
			String status="";
			int eno=0;
			String ename="";
			float esal=0;
			String eaddr="";
			switch(option) {
			case 1:
				System.out.println("=============ADD Module=============");
				System.out.print("Employee Number  :");
				 eno=Integer.parseInt(br.readLine());
				System.out.print("Employee Name  :");
				 ename=br.readLine();
				System.out.print("Employee Salary  :");
				 esal =Float.parseFloat(br.readLine());
				System.out.print("Employee Address  :");
				 eaddr= br.readLine();
				emp=new Employee();
				emp.setEno(eno);
				emp.setEname(ename);
				emp.setEsal(esal);
				emp.setEaddr(eaddr);
				status=dao.add(emp);
				System.out.println(status);
				
				break;
			case 2:
				System.out.println("=============Search Module=============");
				System.out.print("Employee Number  :");
				 eno=Integer.parseInt(br.readLine());
				 emp=dao.search(eno);
				 if(emp==null) {
					 System.out.println("Employee not Existed");
				 }else {
					     System.out.println("Employee Deatils");
					     System.out.println("-----------------------");
					     System.out.println("Employee number :"+emp.getEno());
					     System.out.println("Employee Name  :"+emp.getEname());
						System.out.println("Employee Salary  :"+emp.getEsal());
						System.out.println("Employee Address  :"+emp.getEaddr());
					
				 }
				break;
			case 3:
				System.out.println("===========Update Module============");
				System.out.print("Employee Number  :");
				eno=Integer.parseInt(br.readLine());
				emp=dao.search(eno);
				if(emp==null) {
					System.out.println("Employee Not Existed");
				}else {
					  System.out.println("Employee number :"+emp.getEno());
					  System.out.print("Employee Name [old   :"+emp.getEname()+"]:");
					  String ename_New =br.readLine();
					  System.out.print("Employee Salary [old :"+emp.getEsal()+"]");
					  float esal_New=Float.parseFloat(br.readLine());
					  System.out.print("Employee Address [old  :"+emp.getEaddr()+"]");
					  String address_New =br.readLine();
					  
					  Employee emp_New = new Employee();
					  emp_New.setEno(eno);
					  emp_New.setEname(ename_New);
					  emp_New.setEsal(esal_New);
					  emp_New.setEaddr(eaddr);
					  
					  status=dao.update(emp_New);
					  System.out.println(status);
					  
				}
				break;
			case 4:
				System.out.println("=======Delete Module=========");
				System.out.print("Employee Number  :");
				eno=Integer.parseInt(br.readLine());
				status=dao.delete(eno);
				System.out.println(status);
						
				break;
			case 5:
				System.out.println("*****************Thanks you for choosing app***************");
				System.exit(0);
				break;
			default:
				System.out.println("Enter the Option From 1,2,3,4,5");
				break;
					
				
			}
			
		}
		
		/*Employee emp = new Employee();
		emp.setEno(111);
		emp.setEname("AAA");
		emp.setEsal(5000);
		emp.setEaddr("Hyd");
		String status = dao.add(emp);
		System.out.println(status);
*/
		/*
		Employee emp= dao.search(111);
		if(emp==null) {
			System.out.println("Employee Not Existed");
		}else {
			System.out.println("Employee Details");
			System.out.println("-------------------------");
			System.out.println("Enployee Number  :"+emp.getEno());
			System.out.println("Employee Name   :"+emp.getEname());
			System.out.println("Employee Salary   :"+emp.getEsal());
			System.out.println("employee Address   :"+emp.getEaddr());
		}*/
/*
	  Employee emp=new Employee();
		  emp.setEno(111);
		  emp.setEname("XXX");
		  emp.setEsal(9000);
		  emp.setEaddr("Chennai");
		  String status =dao.update(emp);
		  System.out.println(status);
	*/	  
		/*
	  String status=dao.delete(111);
	  System.out.println(status);
	*/
	}


}
