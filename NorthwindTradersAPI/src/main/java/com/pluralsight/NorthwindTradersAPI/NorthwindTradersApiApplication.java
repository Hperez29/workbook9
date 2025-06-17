package com.pluralsight.NorthwindTradersAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.pluralsight.NorthwindTradersAPI",
		"com.example.northwindtradersapi"
})
public class NorthwindTradersApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(NorthwindTradersApiApplication.class, args);
	}
}