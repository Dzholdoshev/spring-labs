package com.cydeo.repository;

import com.cydeo.modul.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeRepositoryImpl implements RecipeRepository {
    List<Recipe>recipeList= new ArrayList<>();

    @Override
    public  Boolean saveRecipe(Recipe recipe) {
        System.out.println("added to list");
       recipeList.add(recipe);
        return true;
    }
}
