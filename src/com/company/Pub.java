package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pub {
    //Attributes
    ArrayList<Beer> beers;

    /**
     * Constructor of the class
     * Creates an ArrayList with the beers
     */
    public Pub(){
        beers = new ArrayList<>();
    }

    /**
     * Loads the beers from a json file to the ArrayList of the class
     *
     * @param fileName string with the name of the json which wanted to be loaded
     */
    public void LoadBeers(String fileName){
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(fileName));
            JSONArray jsonArray = (JSONArray) object;
            for(int i = 0;i < jsonArray.size(); i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String type = (String) jsonObject.get("type");
                String name = (String) jsonObject.get("name");
                String id = (String) jsonObject.get("id");
                String brand = (String) jsonObject.get("brand");
                int price = Integer.parseInt((String) jsonObject.get("price"));
                double alcohol = Double.parseDouble((String) jsonObject.get("alcohol"));
                boolean isCan = (boolean) jsonObject.get("isCan");
                JSONArray ingArray = (JSONArray) jsonObject.get("ingredients");
                ArrayList<Ingredient> ingredients= new ArrayList<>();
                for(int j = 0;j < ingArray.size(); j++){
                    JSONObject ingObject = (JSONObject) ingArray.get(j);
                    String ingId = (String) ingObject.get("id");
                    double ingRatio = Double.parseDouble((String) ingObject.get("ratio"));
                    String ingName = (String) ingObject.get("name");
                    ingredients.add(new Ingredient(ingId, ingRatio, ingName));
                }
                beers.add(new Beer(type, name, id, brand, price, alcohol, ingredients, isCan));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Groups the beers by brands
     *
     * @return an ArrayList with the grouped beers
     */
    public ArrayList<Brand> GroupByBrands(){
        ArrayList<Brand> brandArrayList = new ArrayList<>();
        for (Beer beer : beers) {
            boolean brandFound = false;
            for (int j = 0; j < brandArrayList.size() && !brandFound; j++) {
                if (brandArrayList.get(j).getBrandName().equals(beer.getBrand())) {
                    brandArrayList.get(j).addBeer(beer);
                    brandFound = true;
                }
            }
            if (!brandFound) {
                Brand newBrand = new Brand(beer.getBrand());
                newBrand.addBeer(beer);
                brandArrayList.add(newBrand);
            }
        }
        return brandArrayList;
    }

    /**
     * Filters the beers by the given type
     *
     * @param beerType string with the wanted beer type
     * @return an ArrayList of the beers with the given type
     */
    public ArrayList<Beer> BeerTypeFilter(String beerType){
        ArrayList<Beer> filteredBeers = new ArrayList<>();
        for (Beer beer : beers){
            if (beer.getType().equals(beerType)){
                filteredBeers.add(beer);
            }
        }
        return filteredBeers;
    }

    /**
     * Returns the name of the brand which has the cheapest average price per liter
     *
     * @return a string with the name of the cheapest brand
     */
    public String CheapestBrand(){
        ArrayList<Brand> brands = (ArrayList<Brand>) this.GroupByBrands().clone();
        String cheapestBrand = "";
        double cheapestPrice = 0;
        for (Brand brand : brands){
            ArrayList<Beer> beersOfBrand = brand.getBeers();
            int sum = 0;
            int num = 0;
            for(Beer beer : beersOfBrand){
                sum += beer.getPrice();
                num++;
            }
            double average = (double) sum / num;
            if(average<cheapestPrice || cheapestPrice==0){
                cheapestPrice = average;
                cheapestBrand = brand.getBrandName();
            }
        }
        return cheapestBrand;
    }

    /**
     * Filters the beers which lack of the given ingredient
     *
     * @param ingredientName string with tha name of the ingredient
     * @return ArrayList of the beers which lack of the given ingredient
     */
    public ArrayList<Beer> LackIngredient(String ingredientName){
        ArrayList<Beer> lackIngredientBeers = new ArrayList<>();
        for (Beer beer : beers){
            ArrayList<Ingredient> ingredients = (ArrayList<Ingredient>) beer.getIngredients().clone();
            boolean isIngredient = false;
            for (Ingredient ingredient : ingredients){
                if (ingredient.getIngredientName().equals(ingredientName)) {
                    isIngredient = true;
                    break;
                }
            }
            if(!isIngredient){
                lackIngredientBeers.add(beer);
            }
        }
        return lackIngredientBeers;
    }

    /**
     * Sorts the beers by water ratio
     *
     * @return an ArrayList of the sorted beers
     */
    public ArrayList<Beer> WaterRatio(){
        ArrayList<Beer> beersByWaterRatio = (ArrayList<Beer>) beers.clone();
        beersByWaterRatio.sort(new WaterComparator());
        return  beersByWaterRatio;
    }

    /**
     * A HashMap where the keys are the rounded prices rounded to the nearest hundred
     *
     * @return a HashMap
     */
    public HashMap<Integer, List<Beer>> HashMap(){
        HashMap<Integer, List<Beer>> hashMap = new HashMap<>();
        ArrayList<Beer> beerArrayList = (ArrayList<Beer>) beers.clone();
        for (Beer beer : beerArrayList) {
            int price = beer.getPrice();
            int roundedPrice = ((price + 99) / 100 ) * 100;
            ArrayList<Beer> hashBeerList = new ArrayList<>();
            if(hashMap.containsKey(roundedPrice)) {
                hashBeerList = (ArrayList<Beer>) hashMap.get(roundedPrice);

            }
            hashBeerList.add(beer);
            hashMap.put(roundedPrice, hashBeerList);
        }
        return hashMap;
    }
}
