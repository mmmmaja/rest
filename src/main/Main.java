package main;

import menu.*;
import restaurant.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();

        Ingredient milk = new Ingredient(1.0, "milk");
        Ingredient nuts = new Ingredient(1.5, "nuts");
        Ingredient flavour = new Ingredient(2.0, "flavour");
        Ingredient tomato = new Ingredient(2.5, "tomato");

        Drink d1 = new Drink("drink1", 2.6);
        Drink d2 = new Drink("drink2", 0.5);
        Drink d3 = new Drink("drink3", 10.0);

        ArrayList<Ingredient> cakeIngredients = new ArrayList<>();
        cakeIngredients.add(milk);
        cakeIngredients.add(flavour);
        cakeIngredients.add(nuts);

        ArrayList<Ingredient> soupIngredients = new ArrayList<>();
        soupIngredients.add(tomato);

        Dish cake = new Dish("cake", cakeIngredients, DishType.dessert);
        Dish soup = new Dish("soup", soupIngredients, DishType.sideDish);

        menu.addDish(cake);
        menu.addDish(soup);
        menu.addDrink(d1);
        menu.addDrink(d2);
        menu.addDrink(d3);

        // Adding new restaurant w/ menu
        Restaurant restaurant = new Restaurant(RegisteredRests.A, menu);
        // Creating order scenario: dine-in at 10:00
        Order order = new Order(10, true, restaurant);
        // Returns current menu prices of restaurant A
        Menu menuA = restaurant.getCurrentMenu(order);

        // Dish pasta = new Dish("pasta", soupIngredients, DishType.mainDish);
        // order.addToOrder(pasta); // Throw exception

        // TODO: Need to make sure only "valid" items are added (i.e., present on restaurant's menu)
        order.addToOrder(menuA.getDesserts().get(0));
        order.addToOrder(menuA.getSideDishes().get(0));

        System.out.println(order.getOrder());
        System.out.println(order.getTotal());
    }
}
