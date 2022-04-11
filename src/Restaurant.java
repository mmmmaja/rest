import menu.Menu;

import java.util.ArrayList;

public abstract class Restaurant {

    private final String restaurantName;
    private final Menu menu;

    public Restaurant(String restaurantName, Menu menu) {
        this.restaurantName = restaurantName;
        this.menu = menu;
    }

    //abstract double computePrice(int time,);
}
