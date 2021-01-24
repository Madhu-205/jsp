package com.madhu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.madhu.bean.Customer;

public class CustomerMapper implements RowMapper<Customer> {
  @Override
public Customer mapRow(ResultSet rs, int row_NO ) throws SQLException {
	Customer ctd = new Customer();
	ctd.setCid(rs.getString("CID"));
	ctd.setCname(rs.getString("CNAME"));
	ctd.setCaddr(rs.getString("caddr"));
	return ctd;
	
}
}
