package controller;

import java.util.ArrayList;

import database.MemberDatabase;
import models.Member;

public class MemberController {
	
//	private ArrayList<Member> memberList = new ArrayList<>();
	private MemberDatabase memberDb;
	
	public MemberController() {
		memberDb = MemberDatabase.getInstance();
	}
	
	public void removeMember(int id) {
		memberDb.removeMember(id);
		System.out.println("Member removed");
	}
	
	public ArrayList<Member> getAllMembers(){
		return memberDb.getAllMembers();
	}

}
