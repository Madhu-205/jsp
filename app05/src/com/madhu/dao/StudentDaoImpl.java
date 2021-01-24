package com.madhu.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.madhu.beans.Student;

public class StudentDaoImpl implements StudentDao {
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
   String status="";
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public String add(Student std) {
		String query="insert into std1 values(:sid,:sname,:saddr)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sid", std.getSid());
		map.put("sname", std.getSname());
		map.put("saddr", std.getSaddr());
		namedParameterJdbcTemplate.update(query, map);
		return "success";
	}

	@Override
	public Student search(String sid) {
		String query ="select * from std1 where sid=:sid";
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("sid", sid);
		Student std =namedParameterJdbcTemplate.queryForObject(query, map, new StudentMapper());
		
		return std;
	}

	@Override
	public String update(Student std) {
		String query="update std1 set SNAME=:sname,SADDR=:saddr where SID=:sid";
	    SqlParameterSource paramSource = new BeanPropertySqlParameterSource(std);
		namedParameterJdbcTemplate.update(query, paramSource);
		return "success";
	}

	@Override
	public String delete(String sid) {
		String query="delete from std1 where sid=:sid";
		SqlParameterSource paramSource = new MapSqlParameterSource("sid", sid);
		namedParameterJdbcTemplate.update(query, paramSource);
		return "success";
	}

}
