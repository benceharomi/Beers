package com.company;

import java.util.ArrayList;

public class Brand {
    //Attributes
    String name;
    ArrayList<Beer> beers;

    /**
     * Constructor of the Brand class
     *
     * @param name string with the wanted name of the brand
     */
    public Brand(String name){
        this.name =name;
        this.beers = new ArrayList<>();
    }

    /**
     * Adds a beer to the arraylist of the brand
     *
     * @param beer Beer object which wanted to be added to the brand
     */
    public void addBeer(Beer beer){
        Beer newBeer = new Beer(beer);
        beers.add(newBeer);
    }


    /**
     * Getter of the name of the brand
     *
     * @return string with the name of the brand
     */
    public String getBrandName(){
        return name;
    }

    /**
     * Getter of the beers
     *
     * @return an ArrayList with the beers of the brand
     */
    public ArrayList<Beer> getBeers(){
        return  (ArrayList<Beer>) beers.clone();
    }

    public String toString(){
        return "brand: " + name + " beers: " + beers;
    }
}
