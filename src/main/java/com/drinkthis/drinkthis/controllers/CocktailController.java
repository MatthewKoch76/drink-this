package com.drinkthis.drinkthis.controllers;

import com.drinkthis.drinkthis.models.Cocktail;
import com.drinkthis.drinkthis.models.data.CocktailDao;
import com.drinkthis.drinkthis.models.data.IngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value="cocktail")
public class CocktailController {

    @Autowired
    private CocktailDao cocktailDao;

    @Autowired
    private IngredientDao ingredientDao;

    @RequestMapping(value="")
    public String index(Model model, @RequestParam String searchTerm) {


        model.addAttribute("cocktails", cocktailDao.findAll());
        model.addAttribute("title", "Cocktails");
        return "cocktails/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCocktailForm(Model model){

        ArrayList<String> quantities = new ArrayList<>();
        quantities.add("1/4 oz");
        quantities.add("1/2 oz");
        quantities.add("3/4 oz");
        quantities.add("1 oz");
        quantities.add("1 1/4 oz");
        quantities.add("1 1/2 oz");
        quantities.add("1 3/4 oz");
        quantities.add("2 oz");
        quantities.add("2 1/4 oz");
        quantities.add("2 1/2 oz");
        quantities.add("3 oz");
        quantities.add("2 oz");
        quantities.add("1 dash");
        quantities.add("2 dashes");

        model.addAttribute("quantities", quantities);
        model.addAttribute("ingredients", ingredientDao.findAll());
        model.addAttribute("title","Cocktails");
        return "cocktails/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCocktailForm(@RequestParam String cocktailName,
                                         @RequestParam String recip1string,
                                         @RequestParam String recip2string,
                                         @RequestParam String recip3string,
                                         @RequestParam String recip4string,
                                         @RequestParam String recip5string,
                                         @RequestParam String recip1quant,
                                         @RequestParam String recip2quant,
                                         @RequestParam String recip3quant,
                                         @RequestParam String recip4quant,
                                         @RequestParam String recip5quant,
                                         @RequestParam String cocktailPrep,
                                         @RequestParam String cocktailGarnish
                                         ){

        HashMap<String, String> cocktailRecipe = new HashMap<>();
        cocktailRecipe.put(recip1quant, recip1string);
        cocktailRecipe.put(recip2quant, recip2string);
        cocktailRecipe.put(recip3quant, recip3string);
        cocktailRecipe.put(recip4quant, recip4string);
        cocktailRecipe.put(recip5quant, recip5string);


        Cocktail cocktail = new Cocktail(cocktailName, cocktailRecipe, cocktailPrep, cocktailGarnish);
        cocktailDao.save(cocktail);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCocktailForm(Model model) {
        model.addAttribute("cocktails", cocktailDao.findAll());
        model.addAttribute("title", "Remove Cocktail");
        return "cocktails/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCocktailForm(@RequestParam int[] cocktailIds) {

        for (int cocktailId : cocktailIds) {
            cocktailDao.delete(cocktailId);
        }

        return "redirect:";
    }



}
