package com.example.rest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
public class Recipes{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @JsonProperty("ingredients")
    private String[] ingredients;

    @JsonProperty("instructions")
    private String[] instructions;


    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String[] instructions) {
        this.instructions = instructions;
    }

    public Recipes() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipes)) return false;
        Recipes recipes = (Recipes) o;
        return name.equals(recipes.name) && Arrays.equals(ingredients, recipes.ingredients) && Arrays.equals(instructions, recipes.instructions);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(ingredients);
        result = 31 * result + Arrays.hashCode(instructions);
        return result;
    }
}
