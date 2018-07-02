package com.drinkthis.drinkthis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value="ingredient")
public class IngredientController {

    private static HashMap<String, String> ingredients = new HashMap<>();

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("ingredients", ingredients.keySet());
        model.addAttribute("title", "Ingredients");
        return "ingredients/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddIngredientForm(Model model){

        model.addAttribute("title","Add an Ingredient");
        return "ingredients/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddIngredientForm(@RequestParam String ingredientName,
                                           @RequestParam String ingredientDescription){

        ingredients.put(ingredientName, ingredientDescription);

        return "redirect:";
    }

}
