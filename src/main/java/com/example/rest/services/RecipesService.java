package com.example.rest.services;

import com.example.rest.domain.Recipes;
import com.example.rest.repository.RecipesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RecipesService implements IRecipesService {

   private RecipesRepository recipesRepository;

   public RecipesService(RecipesRepository recipesRepository) {
      this.recipesRepository = recipesRepository;
   }


   @Override
   public Recipes getRecipesById(Long id) {
      return recipesRepository.findById(id).get();
   }

   @Override
   public void updateRecipes(Recipes recipes, Long id) {
      Recipes recipesFromDb = recipesRepository.findById(id).get();
      System.out.println("Recipes to be updated is:"+recipesFromDb.toString());
      recipesFromDb.setName(recipes.getName());
      recipesFromDb.setIngredients(recipes.getIngredients());
      recipesFromDb.setInstructions(recipes.getInstructions());
      recipesRepository.save(recipesFromDb);
   }

   @Override
   public void deleteRecipes(Long recipesId) {
      recipesRepository.deleteById(recipesId);
   }

   @Override
   public List<Recipes> getAllRecipes() {
      List<Recipes> recipesList = new ArrayList<>();
      recipesRepository.findAll().forEach(recipesList::add);
      return recipesList;
   }

   @Override
   public Recipes addRecipes(Recipes recipes) {
      return recipesRepository.save(recipes);
   }

   @Override
   public void saveAllRecipes(List<Recipes> recipesList) {
      recipesRepository.saveAll(recipesList);
   }


}
