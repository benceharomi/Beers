package com.company;

public class Ingredient {
    //Attributes
    private String id;
    private double ratio;
    private String ingredientName;

    /**
     * The constructor of the Ingredient class
     *
     * @param id a string with the ID of the ingredient
     * @param ratio a double with the content ratio of the ingredient
     * @param ingredientName a string with the name of the ingredient
     */
    public Ingredient(String id, double ratio, String ingredientName){
        this.id = id;
        this.ratio = ratio;
        this.ingredientName = ingredientName;
    }

    /**
     * Getter of the ingredient's name
     *
     * @return a string with the name of the ingredient
     */
    public String getIngredientName(){ return ingredientName;}

    /**
     * Getter of the ingredient's ratio
     *
     * @return a double with the ratio of that ingredient in the beer
     */
    public double getRatio(){ return ratio; }
}
