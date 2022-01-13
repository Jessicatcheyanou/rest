package com.example.rest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Recipes{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;




    @JsonProperty("name")
    private String name;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private String[] ingredients;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private String[] instructions;

    public Recipes() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String[] getInstructions() {
        return instructions;
    }
}
