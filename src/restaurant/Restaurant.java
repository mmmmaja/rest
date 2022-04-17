package restaurant;

import delivery.Deliverer;
import menu.*;
import java.util.ArrayList;


public record Restaurant(String restaurantName, Menu menu, ArrayList<Deliverer> deliverers) {


    /**
     * @param time when the order was registered
     * @return current menu depending on the time & whether the order is dined in (OrderOption)
     */
    public Menu getCurrentMenu(int time) {
        double priceMultiplier = setPriceMultiplier(time);

        ArrayList<MenuItem> menuItems = this.menu.copyOf().getMenuItem();
        for (MenuItem menuItem : menuItems) {
            menuItem.setPrice(menuItem.getPrice() * priceMultiplier); // changes price by multiplier
        }
        return new Menu(menuItems);
    }

    /**
     * to be implemented for each restaurant
     *
     * @param time when the order was registered
     * @return new price multiplier based on the current time
     */
    private int setPriceMultiplier(int time) {
        return 1;
    }


    public String getRestaurantName() {
        return this.restaurantName;
    }

    public ArrayList<Deliverer> getDeliverers() {
        return this.deliverers;
    }

    public void deliver() {}

}
