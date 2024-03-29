package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "view/hello";
	}
}
