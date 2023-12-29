package com.coderscampus.benWoodardAssignment9.web;

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
    private List<String> allRecipes() throws IOException {
        List<String> allRecipes = recipeService.postAllRecipes();
        return allRecipes;
    }



    @GetMapping("/vegan-recipes")
    public List<String> veganRecipes() throws IOException {
        List<String> veganRecipes = recipeService.filterVeganRecipes();
        return veganRecipes;
    }
}
