package com.nadyaclothing.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.nadyaclothing.common.entity", "com.nadyaclothing.admin.user"})
public class NadyaClothingBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(NadyaClothingBackEndApplication.class, args);
	}

}
