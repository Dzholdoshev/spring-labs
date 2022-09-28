package com.cydeo;

import com.cydeo.config.AuthorConfig;
import com.cydeo.enums.QuantityType;
import com.cydeo.modul.Ingredients;
import com.cydeo.enums.RecipeType;
import com.cydeo.services.RecipeService;
import com.cydeo.services.impl.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@SpringBootApplication

public class CydeoApplication {

    public static void main(String[] args) {
        ApplicationContext container =   SpringApplication.run(CydeoApplication.class, args);

     RecipeService recipeService =  container.getBean(RecipeService.class);

     recipeService.prepareRecipe();

        AuthorConfig author = container.getBean(AuthorConfig.class);
        System.out.println("Here you are! Author information of the recipe");
        System.out.println("Name: " + author.getName() + " Surname: " + author.getSurname()
                + "\n" + "Phone Number: "  + author.getPhone() + "\n" + "Social Media Links: "
                + author.getSocialMedia() + "\n" + "Email: " + author.getEmail());
}}
