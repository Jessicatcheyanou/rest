package com.example.rest.controller;

import com.example.rest.domain.Recipes;
import com.example.rest.services.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipesController {

    @Autowired
    private RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @GetMapping("/recipes")
    public Iterable<Recipes> get() {
        return recipesService.findAll();
    }

}
