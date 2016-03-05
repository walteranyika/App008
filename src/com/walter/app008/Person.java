package com.walter.app008;

public class Person {
	private String id, names, email, age;
	//emobilis-server.com
	// constructors
	String gender="Male";
	public Person(String id, String names, String email, String age) {
		super();
		this.id = id;
		this.names = names;
		this.email = email;
		this.age = age;
	
	}
	public Person(String names, String email, String age) {
		super();
		
		this.names = names;
		this.email = email;
		this.age = age;
	}
    //Getters
	public String getId() {
		return id;
	}
	public String getNames() {
		return names;
	}
	public String getEmail() {
		return email;
	}
	public String getAge() {
		return age;
	}
}
