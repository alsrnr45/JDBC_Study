package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

// Controller : View를 통해서 요청한 기능 처리하는 담당 
//              해당 메소드로 전달된 데이터 가공처리 한 후 Dao 메소드 호출시 전달
//              DAO로 부터 반환받은 결과에 따라 사용자가보게 될
//              View(응답화면)를 결정(View 메소드 호출)
public class MemberController {

	
	/**
	 * 사용자의 회원 추가 요청을 처리해주는 메소드
	 * @param userId, userPwd, userName, gender, age, email, phone, address, hobby => 사용자가 요청시 입력했던 값들
	 */

	public void insertMember(String userId, String userPwd, String userName, String gender,
							 int age, String email, String phone, String address, String hobby) {
		
		// 전달된 데이터들을 Member객체 주섬주섬담기
		Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby);
		
		int result = new MemberDao().insertMember(m);
		
		if(result > 0) { // 성공했을 경우
			new MemberMenu().displaySuccess("회원 추가 성공!!");
		}else { // 실패했을 경우 
			new MemberMenu().displayFail("회원 추가 실패 ㅠㅠ");
		}
	}	
		/**
		 * 사용자의 회원 전체 조회 요청을 처리해주는 메소드 
		 */
	public void selectList() {
			
			ArrayList<Member> list = new MemberDao().selectList();
			
			
			// 조회결과가 있는지 없는지 판단 한 후, 사용자가 보게될 View 지정
			// 받아온 list에 결과값이 없다? 있다? 
			if(list.isEmpty()) {
				// 텅빈 리스트일 경우 -> 조회결과 없음
				new MemberMenu().displayNoData("\n전체 조회 결과가 없습니다");
			} else {
				// 무엇이라도 조회 됐을 경우 => 조회결과 있음
				new MemberMenu().displayList(list);
			}
	}
		
		/**
		 * 사용자의 아이디로 검색 요청 처리해주는 메소드 
		 * @param userId
		 */
	public void selectByUserId(String userId) {
			
			Member m = new MemberDao().selectByUserId(userId);
			
			if(m == null) {
				new MemberMenu().displayNoData("\n" + userId + "에 해당하는 검색어가 없습니다.");
			} else {
				new MemberMenu().displayOne(m);
			}
	}
	
	/**
	 * 사용자의 회원명(키워드)으로 검색요청시 처리해주는 메소드
	 * @param keyword 사용자가 입력했던 검색하고자 하는 회원명(키워드)
	 */
	public void selectByUserName(String keyword) {
		
		ArrayList<Member> list = new MemberDao().selectByUserName(keyword);
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("\n" + keyword + "에 대한 검색결과가 없습니다.");
		} else {
			new MemberMenu().displayList(list);
		}
	}
	
	/**
	 * 사용자의 회원정보 변경 요청시 처리해주는 메소드
	 * @param userId 변경하고자 하는 회원아이디
	 * @param userPwd, email, phone, address 변경할 정보(비번, 이메일, 전화번호, 주소)
	 */
	public void updateMember(String userId, String userPwd, String email, String phone, String address) {
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		
		int result = new MemberDao().updateMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 정보 변경 성공!");
		} else {
			new MemberMenu().displayFail("회원 정보 변경 실패!");
		}
	}
	
	/**
	 * 사용자가 회원탈퇴 요청시 처리해주는 메소드
	 * @param userId 사용자가 입력한 탈퇴하고자 하는 회원 아이디 값
	 */
	public void deleteMember(String userId) {
		
		int result = new MemberDao().deleteMember(userId);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 탈퇴 성공!");
		} else {
			new MemberMenu().displayFail("회원 탈퇴 실패!");
		}
	}
}
