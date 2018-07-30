package com.bootcamp.finalProyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

@SpringBootApplication
@RestController
public class FinalProyectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProyectApplication.class, args);
	}

	@RequestMapping("/hello")
	public String sayHello(){
		return "Hello";
	}
}
