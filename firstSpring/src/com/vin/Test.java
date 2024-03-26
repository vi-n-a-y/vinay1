package com.vin;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) {
	
		Resource resource=new ClassPathResource("applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		Student student=(Student)factory.getBean("st2");
		System.out.println(student.getAge());
		System.out.println(student.getName());
		student.show();
		
		
		

	}

}
//https://static.javatpoint.com/src/sp/spcorejars.zip --> for spring jar files.