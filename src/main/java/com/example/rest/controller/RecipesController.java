package com.example.rest.controller;

import com.example.rest.domain.Details;
import com.example.rest.domain.Recipes;
import com.example.rest.services.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("")
public class RecipesController {

    @Autowired
    private RecipesService recipesService;

    @GetMapping("/recipes")
    public ResponseEntity<Iterable<Recipes>> getAllRecipes() {
        Iterable<Recipes> recipesList = recipesService.getAllRecipes();
        return new ResponseEntity<>(recipesList, HttpStatus.OK);
    }

    @GetMapping("/recipes/recipesNames")
    public ResponseEntity<List<String>> getAllRecipesNames() {
        List<String> recipesNamesList = recipesService.getAllRecipesNames();
        return new ResponseEntity<>(recipesNamesList,HttpStatus.OK);
    }

    //Get a recipe`s List of Ingredients and Number of steps
    @GetMapping("/recipes/details/{recipeName}")
    public ResponseEntity<Details> getARecipeDetails(@PathVariable String recipeName) {
        return new ResponseEntity<>(recipesService.getRecipeDetails(recipeName),HttpStatus.OK);
    }

    @GetMapping({"/recipes/{recipesName}"})
    public ResponseEntity<Recipes> getRecipes(@PathVariable String recipesName){
        return new ResponseEntity<>(recipesService.getRecipesById(recipesName),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Recipes> saveRecipes(@RequestBody Recipes recipes){
        Recipes recipes1 = recipesService.addRecipes(recipes);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("recipes","/data"+recipes.getName());
        return new ResponseEntity<>(recipes1,httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping({"/recipes/{recipesId}"})
    public ResponseEntity<Recipes> updateRecipes(@PathVariable("recipesId") String recipesId,@RequestBody Recipes recipes){
        recipesService.updateRecipes(recipes,recipesId);
        return new ResponseEntity<>(recipesService.getRecipesById(recipesId),HttpStatus.OK);
    }

    @DeleteMapping({"/recipes/{recipesId}"})
    public ResponseEntity<Recipes> deleteRecipes(@PathVariable("recipesId") String recipesId){
        recipesService.deleteRecipes(recipesId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
