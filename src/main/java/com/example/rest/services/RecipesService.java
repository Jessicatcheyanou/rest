package com.example.rest.services;

import com.example.rest.domain.Recipes;
import com.example.rest.repository.RecipesRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecipesService {

   private RecipesRepository recipesRepository;

   public RecipesService(RecipesRepository recipesRepository) {
      this.recipesRepository = recipesRepository;
   }

   public Iterable<Recipes> findAll() {
      return recipesRepository.findAll();
   }

   public void saveAll(List<Recipes> recipesList){
      recipesRepository.saveAll(recipesList);
   }
}
