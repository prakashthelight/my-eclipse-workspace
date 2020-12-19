package com.samples.buddies;

public class TeamMember {	
	
	private String firstName;
	private String lastName;
	private String email;
	
	private TeamMember buddy;
	
	public TeamMember(String firstName, String lastName, String email) {	
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public TeamMember getBuddy() {
		return buddy;
	}

	public void setBuddy(TeamMember buddy) {
		this.buddy = buddy;
	}

	@Override
	public String toString() {
		return String.format("%s, %s - %s", this.lastName, this.firstName, this.email);
	}
}
