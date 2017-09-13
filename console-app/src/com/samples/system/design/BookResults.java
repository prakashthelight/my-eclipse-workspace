package com.samples.system.design;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * BookResults
 * @author Kumar, Prakash
 *
 */
public class BookResults {
	
	ArrayList<ArrayList<Book>> results;
	
	public BookResults() {
		results = new ArrayList<ArrayList<Book>>();
		int count = 3;
		while(count > 0) {
			ArrayList<Book> books = new ArrayList<Book> ();
			results.add(books);
			count--;
		}
		
		results.get(0).add(new Book("b101", 18));
		results.get(0).add(new Book("b102", 10));
		results.get(0).add(new Book("b103", 5));
		results.get(0).add(new Book("b104", 2));
		
		results.get(1).add(new Book("b211", 12));
		results.get(1).add(new Book("b102", 8));
		results.get(1).add(new Book("b223", 5));
		
		
		results.get(2).add(new Book("b101", 20));
		results.get(2).add(new Book("b102", 8));
		results.get(2).add(new Book("b331", 55));
		results.get(2).add(new Book("b332", 32));
	}
	
	public ArrayList<Book> merge() {
		ArrayList<Book> result = new ArrayList<Book>();
		
		PriorityQueue<Book> q = new PriorityQueue<Book>(new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				if (b1.getId().equals(b2.getId())) {
					return b2.getRating() > b1.getRating() ? 1 : 0;
				} else {
					return b2.rating - b1.rating;
				}
			}
		});
		
		for (ArrayList<Book> books : results) {
			if (books == null || books.size() == 0) return result;			
			for (Book book : books) {
				if (book != null) {
					q.offer(book);
				}
			}
		}
		
		while(!q.isEmpty()) {
			Book b = q.poll();
			
			while (!q.isEmpty() && q.peek().getId().equals(b.getId())) {
				q.poll();
			}
			
			result.add(b);
		}
		
		return result;
	}	
	
	public void printResult() {
		for(Book book : this.merge()) {
			System.out.println(book.id + " " + book.rating);
		}
	}
}
