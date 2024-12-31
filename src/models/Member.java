package models;

public class Member {
	
	private String memberId;
	private String memberName;
	private String memberRole;
	private String username;
	private String password;
	
	public Member(String memberId, String memberName, String memberRole, String username, String password) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberRole = memberRole;
		this.username = username;
		this.password = password;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
