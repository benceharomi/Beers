package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Pub pubOfBoris = new Pub();
        //Loading the beers from a file
        pubOfBoris.LoadBeers("beers.json");

        //1. GroupByBrands method test
        System.out.println("1. GroupByBrands method test:");
        ArrayList<Brand> brands = pubOfBoris.GroupByBrands();
        System.out.println(brands);

        //2. BeerTypeFilter method test
        System.out.println("2. BeerTypeFilter method test:");
        System.out.println("Beers with the type named 'Szűrt':");
        ArrayList<Beer> filteredByType = pubOfBoris.BeerTypeFilter("Szűrt");
        System.out.println(filteredByType);

        //3. CheapestBrand method test
        System.out.println("3. CheapestBrand method test:");
        System.out.println(pubOfBoris.CheapestBrand());

        //4. LackIngredient method test
        System.out.println("4. LackIngredient method test:");
        System.out.println("The beers which lack the ingredient named 'búza':");
        System.out.println(pubOfBoris.LackIngredient("búza"));

        //5. WaterRatio method test
        System.out.println("5. WaterRatio method test:");
        System.out.println(pubOfBoris.WaterRatio());

        //6. HashMap method test
        System.out.println("6. HashMap method test:");
        for(int key : pubOfBoris.HashMap().keySet()){
            System.out.println(key + " " + pubOfBoris.HashMap().get(key));
        }

    }
}
