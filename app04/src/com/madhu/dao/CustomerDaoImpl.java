package com.madhu.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.madhu.bean.Customer;

public class CustomerDaoImpl implements CustomerDao {
   private JdbcTemplate jdbcTemplate;
   String status="";
	@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;

	}

	@Override
	public String add(Customer ctd) {
		try {
			String query="insert into csd1 values(?,?,?)";
			jdbcTemplate.update(query, new Object[] {ctd.getCid(),ctd.getCname(),ctd.getCaddr()});
			 status="success";
			}catch(Exception e) {
				status="failure";
				e.printStackTrace();
			}
		return status;
	}

	@Override
	public Customer search(String cid) {
		Customer ctd=null;
		try {
			String query="select * from csd1 where cid=?";
			ctd=jdbcTemplate.queryForObject(query,  new Object[]{cid}, new CustomerMapper());
			status="success";
		} catch (Exception e) {
			status="failure";
		    e.printStackTrace();	
		}
		return ctd;
	}

	@Override
	public String update(Customer ctd) {
		try {
		jdbcTemplate.update("update csd1 set cname=?, caddr=? where Cid=?", new Object[] {ctd.getCname(),ctd.getCaddr(),ctd.getCid()});
		status="success";
		}catch(Exception e){
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String cid) {
		try {
			jdbcTemplate.update("delete from csd1 where cid=?", new Object[]{cid});
			status="success";
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

}
