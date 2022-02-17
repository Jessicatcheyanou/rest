package com.example.rest.controller;

import com.example.rest.domain.Details;
import com.example.rest.domain.Recipes;
import com.example.rest.services.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("")
public class RecipesController {

    @Autowired
    private RecipesService recipesService;
    private Details details;

    //Get all recipes
    @GetMapping("/recipes")
    public ResponseEntity<Iterable<Recipes>> getAllRecipes() {
        Iterable<Recipes> recipesList = recipesService.getAllRecipes();
        return new ResponseEntity<>(recipesList, HttpStatus.OK);
    }

    //Get the name of all the Recipes
    @GetMapping("/recipes/recipesNames")
    public ResponseEntity<List<String>> getAllRecipesNames() {
        List<String> recipesNamesList = recipesService.getAllRecipesNames();
        return new ResponseEntity<>(recipesNamesList,HttpStatus.OK);
    }

    //Get the following recipe`s details: List of Ingredients and Number of steps

    @GetMapping("/recipes/details/{recipeName}")
    public ResponseEntity<Details> getARecipeDetails(@PathVariable String recipeName) {
        return new ResponseEntity<>(recipesService.getRecipeDetails(recipeName), HttpStatus.OK);    }

    //Get all information concerning a Recipe
    @GetMapping("/recipes/{recipesName}")
    public ResponseEntity<Recipes> getRecipes(@PathVariable String recipesName){

        if(Stream.of(recipesService.getAllRecipesNames()).anyMatch(s -> s.contains(recipesName)))
        {
            return new ResponseEntity<>(recipesService.getRecipesById(recipesName),HttpStatus.OK);
        } else {
           return new ResponseEntity<>(new Recipes(),HttpStatus.OK);
        }

    }

    //Add and save a new Recipe
    @PostMapping("/recipes")
    public ResponseEntity<Recipes> saveRecipes(@RequestBody Recipes recipes){
        return new ResponseEntity<>(recipesService.addRecipes(recipes),HttpStatus.NO_CONTENT);
    }

    //Update a Recipe
    @PutMapping({"/recipes/{recipesId}"})
    public ResponseEntity<Recipes> updateRecipes(@PathVariable("recipesId") String recipesId,@RequestBody Recipes recipes){
        recipesService.updateRecipes(recipes,recipesId);
        return new ResponseEntity<>(recipesService.getRecipesById(recipesId),HttpStatus.NO_CONTENT);
    }

    //
    @DeleteMapping({"/recipes/{recipesId}"})
    public ResponseEntity<Recipes> deleteRecipes(@PathVariable("recipesId") String recipesId){
        recipesService.deleteRecipes(recipesId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
