package com.naver.controller;
//오라클 연결 테스트

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConTest {
	
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static final String USER = "day";
	private static final String PWD = "day";//사용자 비번
	
	@Test//JUnit 연습용 테스트 애노테이션
	public void testOracleCon() throws Exception{
		Class.forName(DRIVER);//오라클 jdbc 클래스 로드
		
		try (Connection con = DriverManager.getConnection(URL,USER, PWD)){
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
