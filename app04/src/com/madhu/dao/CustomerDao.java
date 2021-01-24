package com.madhu.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.madhu.bean.Customer;

public interface CustomerDao {
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
  public String add(Customer ctd);
  public Customer search(String cid);
  public String update(Customer ctd);
  public String delete(String cid);
}
