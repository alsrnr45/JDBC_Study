package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

public class MemberService {

	public int insertMemeber(Member m) {
		
		// Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		// 트랜잭션 처리
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ArrayList<Member> selectList() {
		
		//Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().selectList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int deleteMember(String userId) {
		
		// Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId);
		
		// 트랜잭션 처리
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	public Member selectByUserId(String inputMemberId) {
		
		// Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().selectByUserId(conn, inputMemberId);
		
		JDBCTemplate.close(conn);
		
		return m;
	}


}
