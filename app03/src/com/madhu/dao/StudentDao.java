package com.madhu.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.madhu.bean.Student;

public interface StudentDao {
   public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
   public String add(Student std);
   public Student search(String sid);
   public String update(Student std);
   public String delete(String sid);
}