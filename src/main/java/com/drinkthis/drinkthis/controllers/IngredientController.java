package com.drinkthis.drinkthis.controllers;

import com.drinkthis.drinkthis.models.Ingredient;
import com.drinkthis.drinkthis.models.data.IngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value="ingredient")
public class IngredientController {

    @Autowired
    private IngredientDao ingredientDao;

    /* private static HashMap<String, String> ingredients = new HashMap<>(); */

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("ingredients", ingredientDao.findAll());
        model.addAttribute("title", "Ingredients");
        return "ingredients/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddIngredientForm(Model model){

        model.addAttribute(new Ingredient());
        model.addAttribute("title","Ingredients");
        return "ingredients/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddIngredientForm(@RequestParam String ingredientName,
                                           @RequestParam String ingredientDescription,
                                           @RequestParam String ingredientType){

        Ingredient ingredient = new Ingredient(ingredientName, ingredientDescription, ingredientType);
        ingredientDao.save(ingredient);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveIngredientForm(Model model) {
        model.addAttribute("ingredients", ingredientDao.findAll());
        model.addAttribute("title", "Remove Ingredient");
        return "ingredients/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveIngredientForm(@RequestParam int[] ingredientIds) {

        for (int ingredientId : ingredientIds) {
            ingredientDao.delete(ingredientId);
        }

        return "redirect:";
    }

}
