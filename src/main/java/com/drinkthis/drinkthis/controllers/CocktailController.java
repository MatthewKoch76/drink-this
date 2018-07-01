package com.drinkthis.drinkthis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CocktailController {

    @RequestMapping(value="")
    public String index(Model model){

        model.addAttribute("title", "Title");

        return "index";


    }



}
