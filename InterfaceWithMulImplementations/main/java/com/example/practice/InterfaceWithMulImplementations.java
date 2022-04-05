package com.example.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class InterfaceWithMulImplementations {

	public static void main(String[] args)
	{

		ConfigurableApplicationContext obj = SpringApplication.run(InterfaceWithMulImplementations.class, args);
		Student stud = obj.getBean(Student.class);
		stud.displayName();
	}


}
