package com.revature.util;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.util.ConnectionUtil;

public class TestConnectionUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   JdbcTemplate jdbcTemplate=ConnectionUtil.getjdbcTemplate();
   System.out.println(jdbcTemplate);
	}

}
