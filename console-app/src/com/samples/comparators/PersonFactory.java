package com.samples.comparators;

public class PersonFactory {
	
	
	/**
	 * @return
	 * {@code 
	 * Person[] personsArray = PersonFactory.getPersonList();
	 * Arrays.sort(personsArray, new PersonComparator());
	 * Arrays.sort(personsArray, (Person a, Person b) -> b.getAge() - a.getAge());
	 * Stream<Person> stream = Stream.of(personsArray);
	 * Stream<Person> sortedStream = stream.sorted((Person a, Person b) -> a.getAge() - b.getAge());
	 * sortedStream.forEach(p -> System.out.println(p.toString())); }
	 * 
	 */
	public static Person[] getPersonList() {
		Person[] persons = new Person[6];

		String[] names = new String[] {"Prakash", "Patrick", "Alexander", "Ross", "Mike", "Ramesh"};
		int[] ages = new int[] {12, 24, 78, 54, 10, 16};

		for (int i = 0; i < persons.length; i++) {
			persons[i] = new Person(names[i], ages[i]);
		}
		
		return persons;
	}
}
