package controller;

import java.util.ArrayList;

import database.MemberDatabase;
import factories.MemberFactory;
import models.Member;

public class AuthController {

//	private String u_test = "user", p_test = "user123";
	private String adminUsername = "admin", adminPass = "admin123";
	private MemberDatabase memberDb;
	private ArrayList<Member> memberList;
	private MemberFactory memberFactory = new MemberFactory();
	private Member member;
	
	public AuthController() {
		memberDb = MemberDatabase.getInstance();
		addMember(new Member("A-00001", "Admin", "Admin", "admin", "admin123"));
	}
	
	private void addMember(Member member) {
		memberDb.addMember(member);
	}
	
	public boolean validateUserLogin(String username, String password) {
		
		memberList = memberDb.getAllMembers();
		
		if(username.equals(adminUsername) && password.equals(adminPass)) {
			System.out.println("Admin login");
			return true;
		}
		
		for(Member m : memberList) {
			if(m.getUsername().equals(username) && m.getPassword().equals(password)) {
				System.out.println("Member login");
				return true;
			}
		}
		
		System.out.println("Invalid Credentials");
		return false;
		
	}
	
	public boolean validateRegisterData(String memberName, String memberRole, String username, String password) {
		
		if(memberName.length() < 6 || memberName.length() > 15) {
			System.out.println("Member name must be 6 - 15 characters long. Not more, Not less");
			return false;
		}
		else if(!(memberRole.equals("Member") || memberRole.equals("Admin"))) {
			System.out.println("Member role is not valid");
			return false;
		}
		else if(username.length() < 6) {
			System.out.println("Username must be 6 or more character long");
			return false;
		}
		else if(password.length() < 5) {
			System.out.println("Password must be 6 or more character long");
			return false;			
		}
		
		member = memberFactory.createMember(memberName, memberRole, username, password);
		addMember(member);
		
		return true;
		
	}

	public Member getActiveUser(String username, String password) {
		for(Member m : memberList) {
			if(m.getUsername().equals(username) && m.getPassword().equals(password)) {
				return m;
			}
		}
		
		return null;
	}
	
	public ArrayList<Member> getMemberList(){
		return memberList;
	}
	
	
}
