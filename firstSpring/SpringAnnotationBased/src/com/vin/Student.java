package com.vin;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
//@Component("vinay") we also give below annotations to configure the class
//@Service
//@Repository

public class Student {
	@Value("balu")
	private String name;
	@Value("15")
	private int rollno;
	@Value("56")
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
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}

	
	public void display() {
		System.out.println("Name : "+name);
		System.out.println("Rollno : "+rollno);
		System.out.println("Marks : "+marks);
	}

}
