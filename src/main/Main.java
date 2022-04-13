package main;

import menu.*;
import order.OrderOption;
import restaurant.*;
import java.util.ArrayList;

public class Main {
    // Testing
    public static void main(String[] args) {
        // Creating menu with drinks and dishes, all instances of the latter containing ingredients with a cost
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

        // Adding a new restaurant with menu
        // This new restaurant is in a list of registered restaurants (e.g., the restaurant shows up on the Thuisbezorgd website)
        // Extra feature for websites where multiple restaurants are listed (and customers can view their respective menus)
        Restaurant restaurantA = new Restaurant(RegisteredRestaurants.A, menu);

        // Creating order scenario: dine-in at 10:00
        Order order = new Order(10, restaurantA, OrderOption.dineInInPersonOrder);

        // Returns current menu prices of restaurant A (may vary depending on their registered conditions, e.g., dining in is more expensive, having a discount between certain hours, etc.)
        Menu menuA = restaurantA.getCurrentMenu(order);

        // GUI should ensure that only valid items are displayed 
        // I.e., impossible to order a dish from Restaurant B through Restaurant A; GUI should only show the items present on menuA
        order.addToOrder(menuA.getDesserts().get(0));
        order.addToOrder(menuA.getSideDishes().get(0));

        // Outprints correct ordered menu items & total cost
        System.out.println(order.getMenuItems());
        System.out.println(order.getTotalPrice());
    }
}
