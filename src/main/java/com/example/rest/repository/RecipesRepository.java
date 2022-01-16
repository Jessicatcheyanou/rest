package com.example.rest.repository;

import com.example.rest.domain.Recipes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesRepository extends CrudRepository<Recipes,Long> {
}
