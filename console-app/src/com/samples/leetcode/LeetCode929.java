package com.samples.leetcode;

import java.util.HashSet;

/**
 * Unique Email Addresses
 * https://leetcode.com/problems/unique-email-addresses/
 * @author Kumar, Prakash
 *
 */
public class LeetCode929 {

	public static void main(String[] args) {
		String[] emails = new String[] { "test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com" };
		
		int numberOfUniqueEmails = numUniqueEmails(emails);
		System.out.println("Number of unique emails: " + numberOfUniqueEmails);
	}

	public static int numUniqueEmails(String[] emails) {
		
		HashSet<String> uniqueEmails = new HashSet<String>();
		
		for (String email : emails) {
			String[] parts = email.split("@");
			String userName = parts[0];
			String domain = parts[1];
			
			// truncate everything after first '+'
			if (userName.indexOf('+') > -1) {
				userName = userName.substring(0, userName.indexOf('+'));				
			}
			
			// remove all '.'			
			userName = userName.replaceAll("\\.", "");			
			
			uniqueEmails.add(userName + "@" + domain);
		}
		
		return uniqueEmails.size();
    }

}
