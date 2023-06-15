package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new
				AnnotationConfigApplicationContext(BeanConfig.class);
		Junior coder0 = (Junior)context.getBean(Junior.class);
		Programmer coder1 = context.getBean(Middle.class);
		Programmer coder2 = context.getBean(Seniour.class);
		coder0.doCoding();
		coder1.doCoding();
		coder2.doCoding();
	}

}
