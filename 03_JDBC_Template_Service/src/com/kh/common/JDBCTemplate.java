package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	
	
	// JDBC 과정 중 반복적으로 쓰이는 구문들을 각각의 메소드로 정의해둘 것
	// *재사용할 목적*으로 공통 템플릿 작업진행!
	
	// 이 클래스에서의 모든 메소드들 다 static 메소드(메모리 영역에 올려두고 공유하는 개념)
	// 싱글톤 패턴  : 메모리 영역에 단 한번만 올라간 것을 재사용하는 개념
	
	// 1. DB와 접속된 Connection 객체 생성해서 반환시켜주는 메소드
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 2. finally에 대하여((p)stmt.close(), conn.close() 정석 방식)
	/* 원래 이 과정이 아니라,
	 * finally {
		
		pstmt.close();
		conn.close();
	}
	
	try {
			if((p)stmt != null && !(p)stmt.isClosed()) {
				(p)stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	원래는 이렇게 자원반납 해야하는 거임
	왜? 조건 기술해주냐 -> 앞서서 conn 또는 stmt가 작동도중 오류생겨서 catch에 걸릴경우 conn, stmt 값은 null로 초기화되어버려서
	나중에 close되는 저 구문이 제대로 동작하지 않기때문!
	*/
	
	// 전달받은 JDBC용 객체를 반납시켜주는 메소드
	// 2_1) Connection 객체 전달받아서 반납시켜주는 메소드
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 2_2) Statement 객체 전달받아서 반납시켜주는 메소드
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
			   stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 2_3) ResultSet 객체 전달 받아서 반납시켜주는 메소드
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3. 전달받은 Connection 객체를 가지고 트랜잭션 처리해주는 메소드
	// 3_1) 전달받은 Connection 객체를 가지고 commit 시켜주는 메소드
	
	public static void commit(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3_2) 전달받은 Connection 객체를 가지고 rollback 시켜주는 메소드
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}

