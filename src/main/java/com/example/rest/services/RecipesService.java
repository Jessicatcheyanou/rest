package com.example.rest.services;

import com.example.rest.domain.Recipes;
import com.example.rest.repository.RecipesRepository;
import org.springframework.stereotype.Service;


@Service
public class RecipesService {

   private RecipesRepository recipesRepository;

   public RecipesService(RecipesRepository recipesRepository) {
      this.recipesRepository = recipesRepository;
   }

   public Iterable<Recipes> findAll() {
      return recipesRepository.findAll();
   }

   public void saveAll(Iterable<Recipes> recipesList){
      recipesRepository.saveAll(recipesList);
   }
}
