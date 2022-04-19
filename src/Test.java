// SE_ASS2_Group5
// Marian Chen - 6258052
// Maja Gójska - 6274446

import menu.*;
import order.*;
import restaurant.*;
import java.util.ArrayList;

public class Test {
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

        menu.addMenuItem(cake);
        menu.addMenuItem(soup);
        menu.addMenuItem(d1);
        menu.addMenuItem(d2);
        menu.addMenuItem(d3);

        // Instantiating new deliverer and the actual restaurant
        Deliverer deliverer = new Deliverer("12345");
        ArrayList<Deliverer> deliverers = new ArrayList<Deliverer>();
        deliverers.add(deliverer);
        Restaurant restaurant = new Restaurant("Tester", menu, deliverers);


        // Testing home delivery order via the restaurant
        Order test1 = new Order(10, restaurant, OrderOption.homeDelivery);
        test1.addToOrder(cake);
        test1.addToOrder(soup);
        System.out.println("Order consists of: " + test1.getMenuItems());
        System.out.println("Total price: " + test1.getTotalPrice());
        test1.requestPayment();
        System.out.println(restaurant.deliver(test1.requiresDelivery())); // Shows whether delivery is successful


        // Testing API order
        RestAPI test2 = new RestAPI(restaurant, 10);
        test2.addToOrder(cake);
        test2.addToOrder(soup);
        System.out.println("Order consists of: " + test2.completeOrder().getMenuItems());
        System.out.println("Total price: " + test2.completeOrder().getTotalPrice());
        // Returns ordered items + total price; external ordering website should take care of payment and delivery.
    }
}