# Beers
## Coding Sans - Coding Challange 2020 Q1 test

1. Group beers by brand
2. Filter brands by BeerType
3. Get the cheapest brand
4. Which beers contain a specific ingredient
5. List all beers with Water ingredient ratio (remaining ratio) - sort by ratio
6. Bonus - Hashmap based on properties

JSON file with data can be found here: 
https://drive.google.com/file/d/1FOIa07zRsLmmY5EFWiEqlnfbF5_qFitj/view?usp=sharing

- - - -

Your friend, Boris is running a small craft beer pub in the city. Boris knows the ins and outs of the business but he is terrible with data and computers in general.
 
Luckily, Boris knows you - you’re his smartest friend - since last time you built a strong reputation by helping him install Windows Vista on his computer.
 
So he decided to drop you an out of the blue message at 23:37 Friday night.

> Boris: Yo! My friend, I need some help with the pub’s beer administration. I just need a few easy reports so I can optimize my business. Come over tomorrow morning.
 
Since Boris knows where you live and he is quick to lose his temper, you answered:
 
> You: Sure, man.

You show up next morning and see this:


### 1. Group beers by brand:

Boris has a list of all the beers available in his pub, but it’s a huge mess. He would like to see the beers grouped by brands. Boris also told you that the Function should return an array of Brand objects which contain the array of Beers of that Brand.

Example:
```
[{brand: Dreher, beers: [{...}, ...]}]
```
### 2. Filter brands by BeerType

Ok my friend. Good job! Just one more thing…

You know, some of my friends are picky. They don’t like every type of beer. I need a list of the beer brands filtered by beer types. Keep in mind that the Function should take BeerType and return all the beers in an array of that type.

### 3. Get the cheapest brand

Did I tell you that you’re my smartest friend? And I have a lot of good friends!
Okay! Just one more thing, good?

You know, sometimes my friends come over and I give them 1-2 beers for free. Luckily, they’re not picky at all, they drink everything. So I need a list of the cheapest beers in my pub so I can avoid giving them expensive ones. Understand?

My friend, here is what I need: a Function that returns the name of the brand that has the cheapest average price. The price is provided per liter.


### 4. Which beers lack a specific ingredient

Do you know my friend Vasily Grigoryevich Zaytsev? NO??
Never mind!

He has some problems drinking wheat beer and I want to help him because he is my best friend, understand? We friends help each other, right? 

Here is what I need: a Function that takes an ingredient name and returns an array of beers that lack this ingredient.
Friendly note from Boris: don’t mess this up! If Vasily gets sick, he will be very upset. He isn’t as patient as I’m!

### 5. List all beers with Water ingredient ratio (remaining ratio) - sort by ratio

Oh yeah, you got this! Just do one more for fun! I want to know the water ratio of the different beers I have!

Function should return all beers sorted descending by their water ingredient ratio. The remaining part of the ingredients is the water.

### 6. Bonus - Hashmap based on properties

We’re having fun my friend! Let’s do another one:

Function should return a map where the keys are the prices rounded to the nearest hundred.
```
{ “100”: [ { price: 1, ... }, { price: 100, ... }, ... ], “200”: [ { price: 101, ... }, { price: 200, ... }, ... ] }
```

[![Run on Repl.it](https://repl.it/badge/github/benceharomi/Beers)](https://repl.it/github/benceharomi/Beers)
