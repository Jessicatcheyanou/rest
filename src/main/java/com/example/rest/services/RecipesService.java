package com.example.rest.services;

import com.example.rest.domain.Data;
import com.example.rest.domain.Details;
import com.example.rest.domain.Recipes;
import com.example.rest.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class RecipesService implements IRecipesService {

   @Autowired
   private RecipesRepository recipesRepository;


   @Override
   public Recipes getRecipesById(String id) {
      return recipesRepository.findById(id).get();
   }

   @Override
   public void updateRecipes(Recipes recipes, String id) {
      Recipes recipesFromDb = recipesRepository.findById(id).get();
      System.out.println("Recipes to be updated is:"+ recipesFromDb.getName());
      recipesFromDb.setName(recipes.getName());
      recipesFromDb.setIngredients(recipes.getIngredients());
      recipesFromDb.setInstructions(recipes.getInstructions());
      recipesRepository.save(recipesFromDb);
   }

   @Override
   public void deleteRecipes(String recipesId) {
      recipesRepository.deleteById(recipesId);
   }

   @Override
   public List<Recipes> getAllRecipes() {

      return (List<Recipes>) recipesRepository.findAll();
   }

   @Override
   public Recipes addRecipes(Recipes recipes) {
      return recipesRepository.save(recipes);
   }

   @Override
   public void saveAllRecipes(Data recipesList) {
      recipesRepository.saveAll(recipesList.recipes);
   }

   @Override
   public List<String> getAllRecipesNames() {
      List<String> recipesNames = new ArrayList<>();
      for (Recipes recipes:getAllRecipes()){
         recipesNames.add(recipes.getName());
      }
      return recipesNames;
   }

   @Override
   public Details getRecipeDetails(String recipeName) {
      Details details = new Details();

      for (Recipes recipeN: getAllRecipes()){
         if (Objects.equals(recipeN.getName(), recipeName)){
            details.setIngredients(recipeN.getIngredients());
            details.setNumSteps(recipeN.getInstructions().length);
         }
      }
      return details;
   }


}
