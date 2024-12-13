package com.negi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.negi.model.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
    List<Recipe> findByTitleContainingIgnoreCase(String title);

}
