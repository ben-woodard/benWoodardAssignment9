package com.coderscampus.benWoodardAssignment9.service;

import com.coderscampus.benWoodardAssignment9.domain.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    private FileService fileService;

    public List<Recipe> createRecipeList() throws IOException {
        Recipe recipe = new Recipe();
        List<Recipe> recipesList = new ArrayList<>();

        Reader recipesFile = new FileReader("recipes.txt");
        @SuppressWarnings("deprecation")
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(',').withFirstRecordAsHeader().withIgnoreSurroundingSpaces();
        Iterable<CSVRecord> records = format.parse(recipesFile);

        for (CSVRecord record : records) {
            recipe.setCookingMinutes(Integer.parseInt(record.get(0)));
            recipe.setDairyFree(Boolean.parseBoolean(record.get(1)));
            recipe.setGlutenFree(Boolean.parseBoolean(record.get(2)));
            recipe.setInstructions(record.get(3));
            recipe.setPreparationMinutes(Double.parseDouble(record.get(4)));
            recipe.setPricePerServing(Double.parseDouble(record.get(5)));
            recipe.setReadyInMinutes(Integer.parseInt(record.get(6)));
            recipe.setServings(Integer.parseInt(record.get(7)));
            recipe.setSpoonacularScore(Double.parseDouble(record.get(8)));
            recipe.setTitle(record.get(9));
            recipe.setVegan(Boolean.parseBoolean(record.get(10)));
            recipe.setVegetarian(Boolean.parseBoolean(record.get(11)));

            recipesList.add(recipe);
        }
        return recipesList;
    }
}
