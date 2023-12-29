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

    private Iterable<CSVRecord> readFile() throws IOException {
        Reader recipesFile = new FileReader("recipes.txt");
        @SuppressWarnings("deprecation")
        CSVFormat format = CSVFormat.Builder.create()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setIgnoreSurroundingSpaces(true)
                .setEscape('\\')
                .setQuote('"')
                .setDelimiter(',')
                .build();

        Iterable<CSVRecord> recipeRecords = format.parse(recipesFile);
        return recipeRecords;
    }

    public List<Recipe> createRecipeList() throws IOException {
        FileService fileService = new FileService();
        List<Recipe> recipesList = new ArrayList<>();
        Iterable<CSVRecord> records = fileService.readFile();

        for (CSVRecord record : records) {
            Recipe recipe = new Recipe(
                    Integer.parseInt(record.get("Cooking Minutes")),
                    Boolean.parseBoolean(record.get("Dairy Free")),
                    Boolean.parseBoolean(record.get("Gluten Free")),
                    record.get("Instructions"),
                    Double.parseDouble(record.get("Preparation Minutes")),
                    Double.parseDouble(record.get("Price Per Serving")),
                    Integer.parseInt(record.get("Ready In Minutes")),
                    Integer.parseInt(record.get("Servings")),
                    Double.parseDouble(record.get("Spoonacular Score")),
                    record.get("Title"),
                    Boolean.parseBoolean(record.get("Vegan")),
                    Boolean.parseBoolean(record.get("Vegetarian")));

            recipesList.add(recipe);
        }
        return recipesList;
    }


}
