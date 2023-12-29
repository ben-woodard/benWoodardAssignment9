package com.coderscampus.benWoodardAssignment9.service;

import com.coderscampus.benWoodardAssignment9.domain.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    public Iterable<CSVRecord> readFile() throws IOException {
        @SuppressWarnings("deprecation")
        CSVFormat format = CSVFormat.Builder.create()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setIgnoreSurroundingSpaces(true)
                .setEscape('\\')
                .setQuote('"')
                .setDelimiter(',')
                .build();

        Iterable<CSVRecord> recipeRecords = format.parse(new FileReader("recipes.txt"));
        return recipeRecords;
    }

    public List<Recipe> createRecipeList() throws IOException {
        FileService fileService = new FileService();
        Recipe recipe = new Recipe();
        List<Recipe> recipesList = new ArrayList<>();
        Iterable<CSVRecord> records = fileService.readFile();


        for (CSVRecord record : records) {
            recipe.setCookingMinutes(Integer.valueOf(record.get("Cooking Minutes")));
            recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
            recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
            recipe.setInstructions(record.get("Instructions"));
            recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
            recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
            recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
            recipe.setServings(Integer.parseInt(record.get("Servings")));
            recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
            recipe.setTitle(record.get("Title"));
            recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
            recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));

            recipesList.add(recipe);
        }
        return recipesList;
    }


}
