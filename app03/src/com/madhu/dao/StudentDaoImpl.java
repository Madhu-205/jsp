package com.madhu.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.madhu.bean.Student;

public class StudentDaoImpl implements StudentDao {
     private JdbcTemplate jdbcTemplate;
     String status;
	 @Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	@Override
	public String add(Student std) {
		try {
			jdbcTemplate.update("insert into std1 values('"+std.getSid()+"','"+std.getSname()+"','"+std.getSaddr()+"')");
			status="Success";
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student std=null;
		try {
			std=jdbcTemplate.queryForObject("select * from std1 where sid='"+sid+"'",new StudentMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}

	@Override
	public String update(Student std) {
		try {
			jdbcTemplate.update("update std1 set sname='"+std.getSname()+"',saddr='"+std.getSaddr()+"' where sid='"+std.getSid()+"'");
			status="success";
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String sid) {
		try {
		jdbcTemplate.update("delete from std1 where sid='"+sid+"'");
		status="success";
		}catch(Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

}
