package com.coderscampus.benWoodardAssignment9.service;

import com.coderscampus.benWoodardAssignment9.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private FileService fileService;

    public List<Recipe> postAllRecipes() throws IOException {
        List<Recipe> allRecipes = fileService.createRecipeList();
        return allRecipes;
    }

    public List<Recipe> filterVeganRecipes() throws IOException {
        List<Recipe> recipeList = fileService.createRecipeList();
        List<Recipe> veganRecipes = recipeList.stream()
                .filter(recipes -> (recipes.getVegan()).equals(true))
                .collect(Collectors.toList());
        return veganRecipes;
    }

    public List <Recipe> filterGlutenFreeRecipes() throws IOException {
        List<Recipe> recipeList = fileService.createRecipeList();
        List<Recipe> glutenFreeRecipes = recipeList.stream()
                .filter(recipes -> recipes.getGlutenFree())
                .collect(Collectors.toList());
        return glutenFreeRecipes;
    }

    public List <Recipe> filterGfAndVegan() throws IOException {
        List<Recipe> recipeList = fileService.createRecipeList();
        List<Recipe> gfAndVeganRecipes = recipeList.stream()
                .filter(recipes -> recipes.getGlutenFree() && recipes.getVegan())
                .collect(Collectors.toList());
        return gfAndVeganRecipes;
    }

    public List <Recipe> filterVegetarian() throws IOException {
        List<Recipe> recipeList = fileService.createRecipeList();
        List<Recipe> vegetarianRecipes = recipeList.stream()
                .filter(recipes -> recipes.getVegetarian())
                .collect(Collectors.toList());
        return vegetarianRecipes;
    }
}
