package com.samples.buddies;

import java.util.Comparator;

public class TeamMemberComparator implements Comparator<TeamMember>{

	@Override
	public int compare(TeamMember a, TeamMember b) {		
		return a.getFirstName().compareTo(b.getFirstName()) != 0 ? a.getFirstName().compareTo(b.getFirstName()) : a.getLastName().compareTo(b.getLastName());
	}
}
