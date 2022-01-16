package com.example.rest.controller;

import com.example.rest.domain.Recipes;
import com.example.rest.services.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipesController {

    private RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @GetMapping("/recipes")
    public ResponseEntity<Iterable<Recipes>> getAllRecipes() {
        List<Recipes> recipesList = recipesService.getAllRecipes();
        return new ResponseEntity<>(recipesList, HttpStatus.OK);
    }

    @GetMapping({"/{recipesId}"})
    public ResponseEntity<Recipes> getRecipes(@PathVariable Long recipesId){
        return new ResponseEntity<>(recipesService.getRecipesById(recipesId),HttpStatus.OK);
    }

    public ResponseEntity<Recipes> saveRecipes(@RequestBody Recipes recipes){
        Recipes recipes1 = recipesService.addRecipes(recipes);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("recipes","/data"+recipes.getId().toString());
        return new ResponseEntity<>(recipes1,httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping({"/{recipesId}"})
    public ResponseEntity<Recipes> updateRecipes(@PathVariable("recipesId") Long recipesId,@RequestBody Recipes recipes){
        recipesService.updateRecipes(recipes,recipesId);
        return new ResponseEntity<>(recipesService.getRecipesById(recipesId),HttpStatus.OK);
    }

    @DeleteMapping({"/{recipesId}"})
    public ResponseEntity<Recipes> deleteRecipes(@PathVariable("recipesId") Long recipesId){
        recipesService.deleteRecipes(recipesId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
