package com.onehealth.lifestyleandhistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OneHealthLifeStyleAndHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneHealthLifeStyleAndHistoryApplication.class, args);
	}
	
	@GetMapping
	public String Welcome() {
		
		return "Welcome From OneHealth Team (OneHealth-LifeStyleAndHistory)!!!";
	}

}
