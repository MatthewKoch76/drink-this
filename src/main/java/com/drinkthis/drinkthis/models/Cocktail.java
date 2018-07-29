package com.drinkthis.drinkthis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class Cocktail {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=30)
    private String name;

    @NotNull
    @Size(min=3)
    private String prep;

    private HashMap recipe;

    @NotNull
    @Size(min=3)
    private String garnish;

    private String image;

    public Cocktail(String name, HashMap recipe, String prep, String garnish, String image){
        this.name = name;
        this.prep = prep;
        this.recipe = recipe;
        this.garnish = garnish;
        this.image = image;
    }

    public Cocktail(){}

    public int getId() {
        return id;
    }

    public String getGarnish() {
        return garnish;
    }

    public void setGarnish(String garnish) {
        this.garnish = garnish;
    }

    public String getPrep() {
        return prep;
    }

    public void setPrep(String prep) {
        this.prep = prep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap getRecipe() {
        return recipe;
    }

    public void setRecipe(HashMap recipe) {
        this.recipe = recipe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
