package com.practica.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}

}
