package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode539 {

	public static void main(String[] args) {
		List<String> timePoints = new ArrayList<>(Arrays.asList(new String[] { "05:31", "22:08", "00:35" }));
		System.out.println(findMinDifference(timePoints));
	}

	public static int findMinDifference(List<String> timePoints) {
		// sort list in ascending order to time
		timePoints.sort(new Comparator<String>() {
			@Override
			public int compare(String timePointA, String timePointB) {
				return minuteDiff(timePointA, timePointB);
			}
		});		

		int minDiff = Integer.MAX_VALUE;
		String prevTimePoint = timePoints.get(0);
		
		for (int i = 1; i < timePoints.size(); i++) {			
			String currentTimePoint = timePoints.get(i);
			minDiff = Math.min(minDiff, minuteDiff(currentTimePoint, prevTimePoint));
			prevTimePoint = currentTimePoint;
		}
		
		// lastly see if last and first timePoints are closer if first one is addded with a day
		minDiff = Math.min(minDiff, toMinutes(timePoints.get(0)) + 24 * 60 - toMinutes(timePoints.get(timePoints.size()  - 1)));
		return minDiff;
	}

	public static int minuteDiff(String timePointA, String timePointB) {
		return toMinutes(timePointA) - toMinutes(timePointB);
	}

	public static int toMinutes(String timePoint) {
		String[] time = timePoint.split(":");

		int hour = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);

		return hour * 60 + minutes;
	}
}
