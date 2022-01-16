package com.example.rest.services;

import com.example.rest.domain.Recipes;

import java.util.List;

public interface IRecipesService {
    Recipes getRecipesById(Long id);
    void updateRecipes(Recipes recipes,Long id);
    void deleteRecipes(Long recipesId);
    List<Recipes> getAllRecipes();
    Recipes addRecipes(Recipes recipes);
    void saveAllRecipes(List<Recipes> recipesList);

}
