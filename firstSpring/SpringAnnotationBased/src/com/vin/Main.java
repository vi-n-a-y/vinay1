package com.vin;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vin.resources.SpringConfigFile;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		Student st1=(Student) context.getBean(Student.class);
		st1.display();
	}

}
