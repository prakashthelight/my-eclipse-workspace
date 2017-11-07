package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode056 {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();		
		int[][] input = new int[][] {{1,3},{2,6},{8,10},{15,18}};	
		
		//int[][] input = new int[][] {{1,4},{1,4}};
		//int[][] input = new int[][] {{1,4},{2,3}};
		for (int[] interval : input) {
			intervals.add(new Interval(interval[0], interval[1]));
		}
		
		for (Interval interval : merge(intervals)) {
			System.out.println("[" + interval.start + ", " + interval.end + "]");
		}
	}

	public static List<Interval> merge(List<Interval> intervals) {		
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		
		// Sort list of intervals by their start time
		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		
		List<Interval> mergedIntervals = new ArrayList<>();
		
		Interval interval = intervals.get(0);
		int start = interval.start;
		int end = interval.end;
		
		for (Interval it : intervals) {
			
			// if overlapping interval, move the end
			if (it.start <= end) {
				end = Math.max(end, it.end);					
			} else {				
				// add this, and update start and end for further comparisons
				mergedIntervals.add(new Interval(start, end));
				start = it.start;
				end = it.end;
			}		
		}
		
		// Add last interval
		mergedIntervals.add(new Interval(start, end));
		
		return mergedIntervals;
	}
}

class Interval {

	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
