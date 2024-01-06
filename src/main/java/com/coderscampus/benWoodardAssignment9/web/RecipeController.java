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
        return recipeService.getAllRecipes();
    }

    @GetMapping("/vegan-recipes")
    public List<Recipe> veganRecipes() throws IOException {
        return recipeService.filterVeganRecipes();
    }

    @GetMapping("/gluten-free")
    public List<Recipe> glutenFreeRecipes() throws IOException {
        return recipeService.filterGlutenFreeRecipes();
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> veganAndGlutenFreeRecipes() throws IOException {
        return recipeService.filterGfAndVegan();
    }

    @GetMapping("/vegetarian")
    public List<Recipe> vegetarianRecipes() throws IOException {
        return recipeService.filterVegetarian();
    }
}
