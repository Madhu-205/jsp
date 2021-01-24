package com.madhu.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TransactionDaoImpl implements TransactionDao {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public String transforFunds(String fromAccount, String toAccount, int transfor_Amt) {
		String status;
		int val1=jdbcTemplate.update("update account set BALANCE = BALANCE-"+transfor_Amt+"where ACCNO="+fromAccount+"");
		float f=100/0;
		int val2=jdbcTemplate.update("update account set BALANCE = BALANCE+"+transfor_Amt+"where ACCNO="+toAccount+"");
		if(val1==1 && val2==1) {
			status="Transaction Success";
		}else {
			status="Transaction Failure";
		}
		return status;
	}


}
