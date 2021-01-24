package com.madhu.dao;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.madhu.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcCall=new  SimpleJdbcCall(dataSource).withProcedureName("getAllEmployees");
		jdbcCall.returningResultSet("emps", BeanPropertyRowMapper.newInstance(Employee.class));
		
	}
	@Override
	public Map<String, Object> getAllEmployees() {
		Map<String, Object> map =jdbcCall.execute();
		return map;
	}

}
