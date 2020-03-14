package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class WaterComparator implements Comparator<Beer> {
    /**
     * Compares the beers by water ratio for the descending sorting
     *
     * @param b1 Beer
     * @param b2 Beer
     * @return 0 if the water ratio equals, 1 if the b1's is less, -1 if the b1's more than the b1's
     */
    @Override
    public int compare(Beer b1, Beer b2) {
        ArrayList<Ingredient> ingredients1 = b1.getIngredients();
        double water1 = 1;
        for (Ingredient ingredient : ingredients1){
            water1 -= ingredient.getRatio();
        }
        ArrayList<Ingredient> ingredients2 = b2.getIngredients();
        double water2 = 1;
        for (Ingredient ingredient : ingredients2){
            water2 -= ingredient.getRatio();
        }
        return Double.compare(water2, water1);
    }
}

