package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

public class MemberController {

	/** 
	 * 사용자의 회원 추가 요청시 처리해주는 메소드
	 * @param userId, userPwd, userName, gender, age, email, phone, address, hobby
	 */
	public void insertMember(String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String address, String hobby) {
		
		Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby);
		
		int result = new MemberService().insertMemeber(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 추가 성공!");
		} else {
			new MemberMenu().displayFail("회원 추가 실패!");
		}
	}

	public void selectList() {
		
		ArrayList<Member> list = new MemberService().selectList();
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("전체 조회 결과 없습니다.");
		} else {
			new MemberMenu().displayList(list);
		}
		
	}

	public void selectByUserId(String userId) {
		
		Member m = new MemberService().selectByUserId();
		
		if(m.isEmpty()) {
			new MemberMenu().displayNoData("해당 아이디 조회 결과 없습니다.");
		} else {
			new MemberMenu().displayOne(m);
		}
		
	}

	public void selectByUserName(String keyword) {
		
	}
	
	public void updateMember(String userId, String userPwd, String email, String phone, String address) {
	
		
	}
	
	public void deleteMember(String userId) {
		
		int result = new MemberService().deleteMember(userId);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 삭제 성공!");
		} else {
			new MemberMenu().displayFail("회원 삭제 실패!");
		}
	}

	

}
