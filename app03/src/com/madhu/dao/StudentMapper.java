package com.madhu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.madhu.bean.Student;

public class StudentMapper implements RowMapper<Student> {
 @Override
public Student mapRow(ResultSet rs, int row_No) throws SQLException {
	Student std = new Student();
	std.setSid(rs.getString("SID"));
	std.setSname(rs.getString("SNAME"));
	std.setSaddr(rs.getString("saddr"));
	return std;
}
}
