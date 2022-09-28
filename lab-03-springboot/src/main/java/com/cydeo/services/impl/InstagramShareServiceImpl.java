package com.cydeo.services.impl;

import com.cydeo.modul.Recipe;
import com.cydeo.services.ShareService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("INSTAGRAM")
public class InstagramShareServiceImpl implements ShareService {
    @Override

    public boolean share(Recipe recipe) {

        System.out.println("Shared on instagram");
        System.out.println("RecipeType: " + recipe.getRecipeType());
        System.out.println("Recipe Name " + recipe.getName() );
        System.out.println("Ingredient List ");
        recipe.getIngredients().forEach(ingredients -> {
            System.out.println("    Ingredient Name " + ingredients.getName() + " Quantity : " + ingredients.getQuantity() +
                    " " + ingredients.getQuantityType());
        });
        System.out.println("Preperation: \n" + "\t" + recipe.getPreparation());

        return true;
    }
}
