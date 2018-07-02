package com.drinkthis.drinkthis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value="cocktail")
public class CocktailController {

    static ArrayList<String> cocktails = new ArrayList<>();

    @RequestMapping(value="")
    public String index(Model model){

        model.addAttribute("cocktails", cocktails);
        model.addAttribute("title", "Cocktail");

        return "cocktails/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCocktailForm(Model model){

        model.addAttribute("title","Add a Cocktail");
        return "cocktails/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCocktailForm(@RequestParam String cocktailName){
        cocktails.add(cocktailName);

        return "redirect:";
    }



}
