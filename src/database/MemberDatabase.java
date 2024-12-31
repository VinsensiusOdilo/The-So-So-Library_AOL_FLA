package database;

import java.util.ArrayList;

import models.Member;


public class MemberDatabase {
	
	private ArrayList<Member> memberList;
	private static MemberDatabase instance;
	
	private MemberDatabase() {
		memberList = new ArrayList<>();
	}
	
	public void addMember(Member newMember) {
		memberList.add(newMember);
	}

	public static MemberDatabase getInstance() {
		if(instance == null) {
			instance = new MemberDatabase();
		}
		
		return instance;
	}
	
	public ArrayList<Member> getAllMembers(){
		return memberList;
	}
	
	public void removeMember(int id) {
		memberList.remove(id);
	}

}
