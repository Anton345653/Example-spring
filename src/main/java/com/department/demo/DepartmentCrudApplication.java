package com.department.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "department Service",
description = "сервис для crudDepartment"))
public class DepartmentCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentCrudApplication.class, args);
	}

}
