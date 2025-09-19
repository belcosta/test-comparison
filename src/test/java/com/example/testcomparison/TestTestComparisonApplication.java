package com.example.testcomparison;

import org.springframework.boot.SpringApplication;

public class TestTestComparisonApplication {

	public static void main(String[] args) {
		SpringApplication.from(TestComparisonApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
