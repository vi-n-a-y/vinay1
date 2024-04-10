package com.vin;

public class Student {
	private String name;
	private int rollno;
	private int age;
	private int marks;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public void display() {
		System.out.println("Name : "+name);
		System.out.println("Rollno : "+ rollno);
		System.out.println("Age : "+age);
		System.out.println("Marks : "+marks);
	}
	

	

}
