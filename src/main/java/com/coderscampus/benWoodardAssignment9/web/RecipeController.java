package com.coderscampus.benWoodardAssignment9.web;

import com.coderscampus.benWoodardAssignment9.domain.Recipe;
import com.coderscampus.benWoodardAssignment9.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;


@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/all-recipes")
    private List<Recipe> allRecipes() throws IOException {
        List<Recipe> recipes = recipeService.postAllRecipes();
        return recipes;
    }

    @GetMapping("/vegan-recipes")
    public List<Recipe> veganRecipes() throws IOException {
        List<Recipe> veganRecipes = recipeService.filterVeganRecipes();
        return veganRecipes;
    }

    @GetMapping("/gluten-free")
    public List<Recipe> glutenFreeRecipes() throws IOException {
        List<Recipe>  glutenFreeRecipes = recipeService.filterGlutenFreeRecipes();
        return glutenFreeRecipes;
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> veganAndGlutenFreeRecipes() throws IOException {
        List<Recipe>  veganAndGfRecipes = recipeService.filterGfAndVegan();
        return veganAndGfRecipes;
    }

    @GetMapping("/vegetarian")
    public List<Recipe> vegetarianRecipes () throws IOException {
        List<Recipe> vegRecipes = recipeService.filterVegetarian();
        return vegRecipes;
    }
}
