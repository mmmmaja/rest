package restaurant;

import menu.*;
import java.util.ArrayList;
import order.Order;
import order.OrderOption;

public class Restaurant {

    private final RegisteredRestaurants restaurantName;
    private final Menu menu;
    private double priceMultiplier = 1;
    private boolean happyHour = false; // TODO: Implementation


    public Restaurant(RegisteredRestaurants restaurantName, Menu menu) {
        this.restaurantName = restaurantName;
        this.menu = menu;
    }


    public Menu getMenu() {
        return this.menu;
    }


    public Menu getCurrentMenu(Order order) {
        switch(restaurantName) {
            // Custom price calculations for each restaurant
            case A:
                if (order.getOrderOption().equals(OrderOption.dineInOnlineOrder)
                        || order.getOrderOption().equals(OrderOption.dineInInPersonOrder)) {
                    priceMultiplier = 1.1; // 10% more expensive if eaten in
                }
                break;
            case B:
                if  (order.getHour() == 10) {
                    priceMultiplier = 0.95; // 5% discount for orders placed between 10:00-11:00
                }
                break;
            case C:
                if (order.getOrderOption().equals(OrderOption.dineInOnlineOrder)
                        || order.getOrderOption().equals(OrderOption.dineInInPersonOrder)) {
                    priceMultiplier = 1.05; // 5% more expensive if eaten in
                }
                if (order.getHour() == 16 || order.getHour() == 17)
                    happyHour = true;
                break;
        }


        ArrayList<Drink> drinks = this.menu.copyOf().getDrinks(); // All drinks
        for (Drink drink : drinks) {
            drink.setPrice(drink.getPrice() * priceMultiplier);
        }


        ArrayList<Dish> dishes = this.menu.copyOf().getDishes(); // All dishes
        for (Dish dish : dishes) {
            dish.setPrice(dish.getPrice() * priceMultiplier);
        }

        return new Menu(drinks, dishes);
    }

    public boolean getHappyHour() {
        return this.happyHour;
    }
}
