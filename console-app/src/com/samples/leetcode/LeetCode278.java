package com.samples.leetcode;

/**
 * 278. First Bad Version <br/>
 * https://leetcode.com/problems/first-bad-version/
 * 
 * @author Kumar, Prakash
 * @category Binary Search, Interactive
 *
 */
public class LeetCode278 {

	static int badVersion;
	public static void main(String[] args) {
		
		badVersion = 4;
		System.out.println(firstBadVersion(5));
		
		badVersion = 2;
		System.out.println(firstBadVersion(2));
		
		badVersion = 1702766719;
		System.out.println(firstBadVersion(2126753390));
	}
	
	public static int firstBadVersion1(int n) {
        if (n == 1) {
            return n;
        }
        
        int start  = 1;
        int end = n;
        
        int firstBadVersion = -1;        
        while (start != end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                firstBadVersion = mid;
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        if (start == end) {
            return start;
        }
        
        return firstBadVersion;
    }
	
	public static int firstBadVersion(int n) {
        if (n == 1) return n;
        
        return firstBadVersion(1, n);
    }
    
    public static int firstBadVersion(int start, int end) {
        if (start == end) {
            return start;
        }
            
        if (start+1 == end) {
            return isBadVersion(start) ? start : end;
        }
        
        int mid = start + (end - start) / 2;
        
        if (isBadVersion(mid)) {
            return firstBadVersion(start, mid);
        } else {
            return firstBadVersion(mid+1, end);
        }
    }
    
    /**
     * API provided in problem
     * @param n
     * @return
     */
    public static boolean isBadVersion(int n) {
    	return n >= badVersion;
    }
}
