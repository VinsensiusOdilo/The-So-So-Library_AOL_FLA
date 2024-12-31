package factories;

import java.util.Random;

import models.Member;

public class MemberFactory {
	
	private String memberId;
	private String CHAR_POOL = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Random rand = new Random();
	private int idx = 0;
	
	private String generateMemberId() {
		
		String id = "M-";
		
		for(int i = 0; i < 5; i++) {
			idx = rand.nextInt(CHAR_POOL.length());
			id += CHAR_POOL.charAt(idx);
		}
		
		return id;
	}
	
	public Member createMember(String memberName, String memberRole, String username, String password) {
		
		memberId = generateMemberId();
		return new Member(memberId, memberName, memberRole, username, password);
	}

}
