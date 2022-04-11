import menu.Menu;

import java.util.ArrayList;

public class Restaurant {

    private final String restaurantName;
    private final Menu menu;

    public Restaurant(String restaurantName, Menu menu) {
        this.restaurantName = restaurantName;
        this.menu = menu;
    }


    public Menu getCurrentMenu() {
        // 1. do the copy of the initial menu
        // modify the prices
        return this.menu;
    }


    //abstract double computePrice(int time,);
}
