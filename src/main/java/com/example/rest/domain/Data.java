package com.example.rest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data {

    @JsonProperty("recipes")
    public List<Recipes> recipes;
}
