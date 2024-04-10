package com.vin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("vinay")
	private String name;
	@Value("45")
	private int rollno;
	@Value("88")
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
		System.out.println(name);
		System.out.println(rollno);
		System.out.println(marks);
	}

}
