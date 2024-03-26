package com.vin;

public class Student {
	private int age;
	private String name;
	
public void setAge(int age) {
	this.age=age;
}
public int getAge() {
	return age;
}
public void setName(String name) {
	this.name=name;
}
public String getName() {
	return name;
}
public Student() {
	System.out.println("constructor is called");
}
public Student(int age) {
	this.age=age;
}
public Student(String name) {
	this.name=name;
}
public Student(int age, String name) {
	this.age=age;
	this.name=name;
}
public void show() {
	System.out.println(age + " "+name);
}
}
