package com.coderscampus.benWoodardAssignment9.service;

import com.coderscampus.benWoodardAssignment9.domain.Recipe;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private FileService fileService;

    public List<String> postAllRecipes() throws IOException {
        List<Recipe> recipeList = fileService.createRecipeList();
        List<String> recipeNames = recipeList.stream()
                .map(recipes -> recipes.getTitle())
                .collect(Collectors.toList());
        return recipeNames;
    }

    public List<String> filterVeganRecipes() throws IOException {
        List<Recipe> recipeList = fileService.createRecipeList();
        List<String> veganRecipes = recipeList.stream()
                .filter(recipes -> (recipes.getVegan()).equals(true))
                .map(vegan -> vegan.getTitle())
                .collect(Collectors.toList());
        return veganRecipes;
    }
}
