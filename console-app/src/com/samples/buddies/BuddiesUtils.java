package com.samples.buddies;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BuddiesUtils {
	
	public static List<TeamMember> getTeamMembers() {
		
		LinkedList<TeamMember> list =  new LinkedList<TeamMember>();
		
		//list.add(CreateTeamMember("Prakash", "Kumar", "pk@somedomain.com"));
		
		
		return list;
	}
	
	private static TeamMember CreateTeamMember(String firstName, String lastName, String email) {
		return new TeamMember(firstName, lastName, email);
	}
	
	public static List<TeamMember> AddBuddy(List<TeamMember> members) {
		List<TeamMember> buddyList = new LinkedList<TeamMember>();
		
		while (members.size() > 0) {
			
			int firstIndex = 0;
			if (members.size() > 1) {
				firstIndex = new Random().nextInt(members.size());
			}		
			
			TeamMember firstTeamMember = members.get(firstIndex);
			members.remove(firstIndex);
			
			TeamMember secondTeamMember;
			
			if (members.size() > 0) {
				int secondIndex = 0;
				if (members.size() > 1) {
					secondIndex = new Random().nextInt(members.size());
				}
				
				secondTeamMember = members.get(secondIndex);
				members.remove(secondIndex);
				secondTeamMember.setBuddy(firstTeamMember);
				firstTeamMember.setBuddy(secondTeamMember);				
			}
			
			buddyList.add(firstTeamMember);
			
			if (firstTeamMember.getBuddy() != null) {
				buddyList.add(firstTeamMember.getBuddy());
			}
		}
		
		Collections.sort(buddyList, new TeamMemberComparator());
		return buddyList;
	}
	
	public static void printJSON(List<TeamMember> buddyList) {
		
		JSONArray jArray = new JSONArray();	
		
		for (TeamMember teamMember : buddyList) {
			JSONObject item = new JSONObject();
			try {
				item.put("firstName", teamMember.getFirstName());
				item.put("lastName", teamMember.getLastName());
				item.put("email", teamMember.getEmail());
				
				
				JSONObject buddy = new JSONObject();
				
				if (teamMember.getBuddy() != null) {
					buddy.put("firstName", teamMember.getBuddy().getFirstName());
					buddy.put("lastName", teamMember.getBuddy().getLastName());
					buddy.put("email", teamMember.getBuddy().getEmail());
				}			
				
				item.put("buddy", buddy);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jArray.put(item);
		}
		
		try {
			System.out.println(jArray.toString(3));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
