package restaurant;

import menu.*;
import java.util.ArrayList;

public record Restaurant(String restaurantName, Menu menu, ArrayList<Deliverer> deliverers) {
    /**
     * @param time the order was registered
     * @return Current menu depending on the time & whether the order is dined in (OrderOption)
     */
    public Menu getCurrentMenu(int time) {
        double priceMultiplier = setPriceMultiplier(time);

        ArrayList<MenuItem> menuItems = this.menu.copyOf().getMenuItems();
        for (MenuItem menuItem : menuItems) {
            menuItem.setPrice(menuItem.getPrice() * priceMultiplier); // Changes price by multiplier
        }
        return new Menu(menuItems);
    }


    // TODO!!! THIS A BIT IFFY


    /**
     * To be implemented for each restaurant
     *
     * @param time when the order was registered
     * @return new price multiplier based on the current time
     */
    private int setPriceMultiplier(int time) {
        return 1;
    }

    /**
     * @return Name of restaurant
     */
    public String getRestaurantName() {
        return this.restaurantName;
    }

    /**
     * @return List of deliverers working for the specific company
     */
    public ArrayList<Deliverer> getDeliverers() {
        return this.deliverers;
    }

    /**
     * Method to be implemented by the restaurant
     * @param requiresDelivery from Order.java to see if order requires delivery & has been successfully paid
     * @return True if delivery was successful, false otherwise
     */
    public boolean deliver(boolean requiresDelivery) {
        if(requiresDelivery) {
            // TODO: Use Deliverer.java to see which deliverers are available & to allocate them to an order accordingly
            // Returns true if delivery is successful, false otherwise
        }
        else
            return false;
    }

}
