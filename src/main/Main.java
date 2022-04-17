package main;

import delivery.Deliverer;
import order.OrderProcessing;
import menu.*;
import order.Order;
import order.OrderOption;
import restaurant.*;

import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {

        Menu menu = createMenu();
        OrderProcessing orderProcessing = new OrderProcessing(createDeliverers());

        // Adding new restaurant with menu
        Restaurant restaurant = new Restaurant(RegisteredRestaurants.A, menu);

        // Creating order scenario: dine-in, order in person at 10:00
        Order order = new Order(10, restaurant, OrderOption.dineInInPersonOrder);
        System.out.println(order.getCurrentMenu());
        order.addToOrder("cake");
        order.addToOrder("drink1");
        order.requestPayment();


        if (orderProcessing.processOrder(order)) {
            System.out.println("order was successfully processed");
        }
        else {
            System.out.println("order denied");
        }


        // TODO: Need to make sure only "valid" items are added (i.e., present on restaurant's menu)
        // Dish pasta = new Dish("pasta", soupIngredients, DishType.mainDish);
        // order.addToOrder(pasta); // Throw exception
    }


    private static Menu createMenu() {
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

        return menu;
    }

    private static ArrayList<Deliverer> createDeliverers() {
        ArrayList<Deliverer> deliverers = new ArrayList<>();

        Deliverer deliverer1 = new Deliverer("D1");
        Deliverer deliverer2 = new Deliverer("D2");
        Deliverer deliverer3 = new Deliverer("D3");
        Deliverer deliverer4 = new Deliverer("D4");
        deliverers.add(deliverer1);
        deliverers.add(deliverer2);
        deliverers.add(deliverer3);
        deliverers.add(deliverer4);
        return deliverers;
    }


}
