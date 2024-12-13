package com.negi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.negi.model.Recipe;
import com.negi.model.User;
import com.negi.service.RecipeService;
import com.negi.service.UserService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private UserService userService;

	@PostMapping()
	public Recipe createRecipe(@RequestBody Recipe recipe,
	                           @RequestHeader("Authorization") String jwt) throws Exception {

	    System.out.println("Received Recipe: " + recipe);						
	    User user = userService.findUserByJwt(jwt);

	    Recipe createdRecipe = recipeService.createRecipe(recipe, user);
	    return createdRecipe;
	}	
	
	@GetMapping()
	public List<Recipe> getAllRecipe () throws Exception {
		
		List<Recipe> recipes=recipeService.findAllRecipe();
		return recipes;
		
	}
	
	@DeleteMapping("/{recipeId}")
	public String deleteRecipe (@PathVariable Long recipeId) throws Exception {
		
		recipeService.deleteRecipe (recipeId);
		return "recipe deleted successfully";		
		
	}
	
	@PutMapping("/{id}")
	public Recipe updateRecipe (@RequestBody Recipe recipe, @PathVariable Long id) throws Exception {
	
	Recipe updatedRecipe=recipeService.updateRecipe(recipe, id);
	return updatedRecipe;
	
	}
	
	@PutMapping("/{id}/like")
	public Recipe likeRecipe(@RequestHeader("Authorization") String jwt,
	                         @PathVariable Long id) throws Exception {

	    User user = userService.findUserByJwt(jwt);

	    Recipe updatedRecipe = recipeService.likeRecipe(id, user);

	    return updatedRecipe;
	}

	@GetMapping("/search")
	public ResponseEntity<List<Recipe>> searchRecipes(@RequestParam String query) {
		List<Recipe> results = recipeService.searchRecipes(query);
		return ResponseEntity.ok(results);
	}
	
	
}

