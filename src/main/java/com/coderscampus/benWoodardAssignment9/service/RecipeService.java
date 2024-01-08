package com.coderscampus.benWoodardAssignment9.service;

import com.coderscampus.benWoodardAssignment9.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private FileService fileService;

    private List<Recipe> allRecipes;

    public List<Recipe> getAllRecipes() throws IOException {
        if (CollectionUtils.isEmpty(allRecipes)) {
            allRecipes = fileService.createRecipeList();
        }
        return allRecipes;
    }

    public List<Recipe> filterVeganRecipes() throws IOException {
        return getAllRecipes().stream()
                              .filter(Recipe::getVegan)
                              .collect(Collectors.toList());
    }

    public List<Recipe> filterGlutenFreeRecipes() throws IOException {
        return getAllRecipes().stream()
                              .filter(Recipe::getGlutenFree)
                              .collect(Collectors.toList());
    }

    public List<Recipe> filterGfAndVegan() throws IOException {
        return getAllRecipes().stream()
                              .filter(recipes -> recipes.getGlutenFree() && recipes.getVegan())
                              .collect(Collectors.toList());
    }

    public List<Recipe> filterVegetarian() throws IOException {
        return getAllRecipes().stream()
                              .filter(Recipe::getVegetarian)
                              .collect(Collectors.toList());
    }
}
