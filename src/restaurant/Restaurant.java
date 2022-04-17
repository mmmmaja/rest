package restaurant;

import menu.*;
import java.util.ArrayList;

public record Restaurant(String restaurantName, Menu menu, ArrayList<Deliverer> deliverers) {
    private double priceMultiplier = 1; // Regular price
    /**
     * @param time the order was registered
     * @return Current menu depending on the time & whether the order is dined in (OrderOption)
     */
    public Menu getCurrentMenu(int time, boolean dineIn) {
        this.priceMultiplier = setPriceMultiplier(time);
        this.priceMultipleir = setPriceMultiplier(dineIn);
        // TODO: Additional price changes to be implemented by the restaurant

        ArrayList<MenuItem> menuItems = this.menu.copyOf().getMenuItems();
        for (MenuItem menuItem : menuItems) {
            menuItem.setPrice(menuItem.getPrice() * priceMultiplier); // Changes price by multiplier
        }
        return new Menu(menuItems);
    }

    /**
     * To be implemented for each restaurant
     * Depends on whether restaurant would like to include a discount at a certain time interval
     * @param time when the order was registered
     * @return New price multiplier based on the current time
     */
    private double setPriceMultiplier(int time) {
        return 1;
    }

    /**
     * To be implemented for each restaurant
     * Depends on whether restaurant would like to include a price change for dining in
     * @param dineIn Whether customer eats at the restaurant
     * @return New price multiplier based on dine-in status
     */
    private double setPriceMultiplier(boolean dineIn) {
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
