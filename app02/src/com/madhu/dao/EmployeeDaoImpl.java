package com.madhu.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.madhu.dto.Employee;
import com.madhu.mapper.EmployeeRowMapper;

public class EmployeeDaoImpl implements EmployeeDao {
  private JdbcTemplate JdbcTemplate;
  
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	JdbcTemplate = jdbcTemplate;
}
  
	@Override
	public String add(Employee emp) {
		String status="";
		try {
			List<Employee> empList=JdbcTemplate.query("select * from emp1 where ENO ="+emp.getEno(), new EmployeeRowMapper());
			if(empList.isEmpty()==true) {
				int rowCount =JdbcTemplate.update("insert into emp1 values("+emp.getEno()+", '"+emp.getEname()+"', "+emp.getEsal()+",'"+emp.getEaddr()+"')");
				if(rowCount ==1) {
					status="Employee Inserted SuccessFull";
				}else {
					status="Employee InsertionFailure";
				}
			}else {
				status="Employee Existed already";
			}
		} catch (Exception e) {
			status="Employee Insertion failure";
			e.printStackTrace();
		}
		return status;
	}
	
	

	@Override
	public Employee search(int eno) {
	     String status="";
		try {
			 List<Employee> empList = JdbcTemplate.query("select * from emp1 where ENO ="+eno, new EmployeeRowMapper());
			 boolean b=empList.isEmpty();
			 if(b==true) {
				 status="Employee is not Existed";
			 }else {
				 return empList.get(0);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String update(Employee emp) {
		String status="";
		try {
			Employee emp1= search(emp.getEno());
			if(emp1==null) {
				status="Employee Not Existed";
			}else {
				int rowCount =JdbcTemplate.update("update emp1 set ENAME = '"+emp.getEname()+"',Esal="+emp.getEsal()+",EADDR ='"+emp.getEaddr()+"' where ENO="+emp.getEno());
				if(rowCount == 1) {
				 System.out.println("Employee Updated Successfull");
				}else {
					System.out.println("Employee Update Failure");
				}
			}
		} catch (Exception e) {
			status="Employee Update Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(int eno) {
		String status="";
		try {
			Employee emp=search(eno);
			if(emp==null) {
				status="Employee Not Existed";
			}else {
				int rowCount =JdbcTemplate.update("delete from emp1 where ENO ="+eno);
				if(rowCount ==1) {
					status="Employee Deleated Successfully";
				}else {
					status="Employee Deletion Failure";
				}
			}
		} catch (Exception e) {
			status="Employee Deletion Failure";
			e.printStackTrace();
		}
		return status;
	}

}
