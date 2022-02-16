package com.example.rest;

import com.example.rest.domain.Data;
import com.example.rest.domain.Recipes;
import com.example.rest.services.RecipesService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RecipesService recipesService) {
		return args -> {
			//read and load json
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			TypeReference<Data> typeReference = new TypeReference<>() {
			};

			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");

			try {
				Data data = mapper.readValue(inputStream,typeReference);
				recipesService.saveAllRecipes(data);
				System.out.printf("List of all Recipes saved successfully");
			} catch (IOException exception){
				System.out.println("Unable to save recipes:" + exception.toString());
			}
		};
	}

	}
