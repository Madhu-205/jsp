package com.madhu.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.madhu.beans.Student;

public interface StudentDao {
  public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate);
  public String add(Student std);
  public Student search(String sid);
  public String update(Student std);
  public String  delete(String sid);
}
