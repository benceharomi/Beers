package com.company;

import java.util.ArrayList;

public class Beer {
    //Attributes
    private String type;
    private String name;
    private String id;
    private String brand;
    private int price;
    private double alcohol;
    private ArrayList<Ingredient> ingredients;
    private boolean isCan;

    /**
     * The constructor of the Beer class.
     *
     * @param type a String with the type of the beer
     * @param name a String with the name of the beer
     * @param id a String with the ID of the beer
     * @param brand a String with the brand of the beer
     * @param price an integer with the price of the beer per liter
     * @param alcohol a double with the ratio of the alcohol in the beer
     * @param ingredients an ArrayList of the ingredients which can be found in the beer
     * @param isCan a boolean which is true if the beer is stored in a can
     */
    public Beer(String type, String name, String id, String brand, int price, double alcohol, ArrayList<Ingredient> ingredients, boolean isCan) {
        this.type = type;
        this.name = name;
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.alcohol = alcohol;
        this.ingredients = (ArrayList<Ingredient>) ingredients.clone();
        this.isCan = isCan;
    }

    /**
     * Copy constructor of the beer class.
     *
     * @param beer a Beer object to be copied
     */
    public Beer(Beer beer){
        this.type = beer.type;
        this.name = beer.name;
        this.id = beer.id;
        this.brand = beer.brand;
        this.price = beer.price;
        this.alcohol = beer.alcohol;
        this.ingredients = (ArrayList<Ingredient>) beer.ingredients.clone();
        this.isCan = beer.isCan;
    }


    /**
     * Getter of the beer's brand.
     *
     * @return string with the name of the brand
     */
    public String getBrand() { return brand; }

    /**
     * Getter of the beer's type.
     *
     * @return string with the type of the beer
     */
    public String getType() { return type; }

    /**
     * Getter of the price of the beer
     *
     * @return integer with the price of the beer per liter
     */
    public int getPrice(){ return price; }

    /**
     * Getter of the ingredients
     *
     * @return an ArrayList with the Ingredients
     */
    public ArrayList<Ingredient> getIngredients(){ return ingredients; }

    public String toString()
    {
        return name;
    }

}
