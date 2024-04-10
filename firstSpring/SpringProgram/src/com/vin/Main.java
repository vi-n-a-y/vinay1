package com.vin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
	
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/vin/resources/applicationContext.xml");
		Student st=(Student) context.getBean("st2");
		st.display();

	}

}
//spring-bean-version(xxx).jar
//spring-core-xxx.jar
//spring-context-xxx.jar
//spring-logging-xxx.jar
//spring-expression-xxx.jar
