package com.example.rest.services;

import com.example.rest.domain.Data;
import com.example.rest.domain.Details;
import com.example.rest.domain.Recipes;

import java.util.List;

public interface IRecipesService {
    Recipes getRecipesById(String name);
    void updateRecipes(Recipes recipes,String id);
    void deleteRecipes(String recipesId);
    List<Recipes> getAllRecipes();
    Recipes addRecipes(Recipes recipes);
    void saveAllRecipes(Data recipesList);
    List<String> getAllRecipesNames();
    Details getRecipeDetails(String recipeName);

}
