package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

// View : 사용자가 보게될 시각적인 요소(화면) (출력 및 입력)
public class MemberMenu {
	
	// 전역으로 다 쓸 수 있도록 Scanner 객체 생성
	private Scanner sc = new Scanner(System.in);
	// 전역으로 바로 MemberController 요청할 수 있게끔 객체 생성
	private MemberController mc = new MemberController();
	
	
	/**
	 * 사용자가 보게될 첫 화면 (메인화면)
	 */
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("\n== 회원 관리 프로그램 ==");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("4. 회원 이름으로 키워드 검색");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("7. 로그인");
			System.out.println("0. 프로그램 종료");
			System.out.print("이용할 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: insertMember(); break;
			case 2: mc.selectList(); break;
			case 3: //String userId = inputMemberId();
					//mc.selectByUserId(userId);
					mc.selectByUserId(inputMemberId());
					break;
			case 4: mc.selectByUserName(inputMemberName()); break;
			case 5: updateMember(); break;
			case 6: mc.deleteMember(inputMemberId()); break;
			case 7: loginMember(); break;
			case 0: System.out.println("\n이용해주셔서 감사합니다. 프로그램을 종료합니다."); return;
			default: System.out.println("\n번호를 잘못 입력했습니다. 다시입력해주세요.");
			}
			
		}
		
	}
	
	/**
	 * 회원 추가용 화면
	 * 추가하고자하는 회원의 정보를 입력받아서 추가 요청할 수 있는 화면 
	 */
	public void insertMember() {
		
		System.out.println("\n===== 회원 추가 ======");
		
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();

		System.out.print("이름 : ");
		String userName = sc.nextLine();
		
		System.out.print("성별 (M/F) : ");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("전화번호(-빼고) : ");
		String phone = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("취미(,로 공백없이 나열) : ");
		String hobby = sc.nextLine();
		
		
		// 회원추가요청! => Controller의 어떤 메소드 호출!
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);
		
	}
	
	
	/**
	 * 사용자에게 회원 아이디 입력 받은 후 그 입력한 값 반환해주는 메소드
	 * @return	=> 사용자가 입력한 회원 아이디값
	 */
	public String inputMemberId() {
		
		System.out.print("\n회원 아이디 입력 : ");
		//String userId = sc.nextLine();
		//return userId;
		return sc.nextLine();
		
	}
	
	/**
	 * 사용자에게 검색하고자 하는 회원의 이름(키워드)값 입력받은 후 그 입력한 값 반환해주는 메소드
	 * @return	=> 사용자가 입력한 회원 이름(키워드)값
	 */
	public String inputMemberName() {
		
		System.out.print("\n회원 이름(키워드) 입력 : ");
		return sc.nextLine();
		
	}
	
	
	/**
	 * 사용자에게 변경할 회원의 아이디, 변경할 정보들(비번, 이메일, 전화번호, 주소)을 입력받은 후 변경 요청하는 메소드
	 */
	public void updateMember() {
		
		System.out.println("\n==== 회원 정보 변경 ====");
		
		String userId = inputMemberId(); // 변경할 회원의 아이디
		
		System.out.print("변경할 비번 : ");
		String userPwd = sc.nextLine();
		
		System.out.print("변경할 이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("변경할 전화번호(-제외) : ");
		String phone = sc.nextLine();
		
		System.out.print("변경할 주소 : ");
		String address = sc.nextLine();
		
		mc.updateMember(userId, userPwd, email, phone, address);
		
	}
	
	public void loginMember() {
		System.out.println("\n====== 로그인 ======");
		String userId = inputMemberId();
		
		System.out.println("회원 비번 입력: ");
		String userPwd = sc.nextLine();
		
		mc.loginMember(userId, userPwd);
	}
	
	
	
	
	
	
	
	// --------------------------------------------------
	// 서비스 요청 처리 후 사용자가 보게될 응답화면들
	
	/**
	 * 서비스 요청 성공시 보게될 응답화면
	 * @param message  성공메세지
	 */
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}
	
	/**
	 * 서비스 요청 실패시 보게될 응답화면
	 * @param message  실패메세지
	 */
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
	
	/**
	 * 조회 서비스 요청시 조회결과가 없을때 보게될 응답화면
	 * @param message	메세지
	 */
	public void displayNoData(String message) {
		System.out.println(message);
	}
	
	/**
	 * 조회 서비스 요청시 여러행 조회된 결과 받아서 보게될 응답화면
	 * @param list	여러행 조회된 결과
	 */
	public void displayList(ArrayList<Member> list) {
		
		System.out.println("\n조회된 데이터는 다음과 같습니다.\n");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	/**
	 * 조회 서비스 요청시 한 행 조회된 결과 받아서 보게될 응답화면
	 * @param m
	 */
	public void displayOne(Member m) {
		System.out.println("\n조회된 검색결과는 다음과 같습니다.\n");
		System.out.println(m);
	}
	
	
	
	
}
