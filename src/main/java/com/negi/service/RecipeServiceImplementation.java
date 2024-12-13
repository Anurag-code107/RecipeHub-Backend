package com.negi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negi.model.Recipe;
import com.negi.model.User;
import com.negi.repository.RecipeRepository;

@Service
public class RecipeServiceImplementation implements RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Recipe createRecipe(Recipe recipe, User user) {
		
		Recipe createdRecipe = new Recipe();
		createdRecipe.setTitle(recipe.getTitle());
		createdRecipe.setImage(recipe.getImage());
		createdRecipe.setDescription(recipe.getDescription());
		createdRecipe.setUser(user);
		createdRecipe.setCategory(recipe.getCategory());
		createdRecipe.setCreatedAt(LocalDateTime.now());
		createdRecipe.setInstructions(recipe.getInstructions());
		createdRecipe.setIngredients(recipe.getIngredients());
		return recipeRepository.save(createdRecipe);
	}

	@Override
	public Recipe findRecipeById(Long id) throws Exception {
		
		Optional<Recipe> opt = recipeRepository.findById(id);
		if (opt.isPresent()) {
		    return opt.get();
		} else {
		    throw new Exception("recipe not found with id " + id);
		}
	}

	@Override
	public void deleteRecipe(Long id) throws Exception {
		
		findRecipeById(id);
		recipeRepository.deleteById(id);		
		
	}

	@Override
	public Recipe updateRecipe(Recipe recipe, Long Id) throws Exception {
		
		Recipe oldRecipe = findRecipeById(Id);

		if (recipe.getTitle() != null) {
		    oldRecipe.setTitle(recipe.getTitle());
		}

		if (recipe.getImage() != null) {
		    oldRecipe.setImage(recipe.getImage());
		}

		if (recipe.getDescription() != null) {
		    oldRecipe.setDescription(recipe.getDescription());
		}

		if (recipe.getCategory() != null) {
			oldRecipe.setCategory(recipe.getCategory());
		}

		if (recipe.getInstructions() != null) {
			oldRecipe.setInstructions(recipe.getInstructions());
		}
		if (recipe.getIngredients() != null) {
			oldRecipe.setIngredients(recipe.getIngredients());
		}
		return recipeRepository.save(oldRecipe);
	}

	@Override
	public List<Recipe> findAllRecipe() {
		
		return recipeRepository.findAll();
	}

	@Override
	public Recipe likeRecipe(Long recipeId, User user) throws Exception {
	
		Recipe recipe = findRecipeById(recipeId);

		if (recipe.getLikes().contains(user.getId())) {
		    recipe.getLikes().remove(user.getId());
		} else {
		    recipe.getLikes().add(user.getId());
		}
		
		Recipe savedRecipe = recipeRepository.save(recipe);
		
		return savedRecipe;
		
	}

	@Override
	public List<Recipe> searchRecipes(String query) {
		return recipeRepository.findByTitleContainingIgnoreCase(query);
	}

}
