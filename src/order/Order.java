package order;

import restaurant.*;
import java.util.ArrayList;
import menu.*;

/**
 * Class having all the information about the order
 */
public class Order {
    private final int time;
    private final OrderOption orderOption;
    private final ArrayList<MenuItem> menuItems;
    private final Menu currentMenu;
    private boolean paid;
    private boolean dineIn;

    /**
     * Order that customer places
     * @param time Time (integer hour) that customer places order
     * @param restaurant At which restaurant order is placed
     * @param orderOption Type of order (see enum OrderOption)
     */
    public Order(int time, Restaurant restaurant, OrderOption orderOption) {
        this.time = time;
        this.orderOption = orderOption;
        this.menuItems = new ArrayList<>();
        if(orderOption == OrderOption.dineInInPersonOrder || orderOption == OrderOption.dineInOnlineOrder)
            dineIn = true;
        else
            dineIn = false;
        this.currentMenu = restaurant.getCurrentMenu(this.time, dineIn);
        this.paid = false;
    }

    /**
     * Adds the menuItem to the current order
     * @param menuItem to be added to the order
     */
    public void addToOrder(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    /**
     * @return All the items that this order includes
     */
    public ArrayList<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    /**
     * @return Menu with updated prices based on the special offers and happy hour discounts
     */
    public Menu getCurrentMenu() {
        return this.currentMenu;
    }

    /**
     * @returnTtotal Price of the order including special offers and happy hours
     */
    public double getTotalPrice() {
        double total = 0;
        for (MenuItem menuItem : menuItems) {
            total += menuItem.getPrice();
        }
        return total;
    }

    /**
     * Asks the customer to make the payment
     * Method to be implemented by the restaurant
     * Should update the global boolean paid
     */
    public void requestPayment() {
        // TODO
        this.paid = true;
    }

    /**
     * @return True if payment for the order was registered
     */
    public boolean getPaid() {
        return this.paid;
    }

    /**
     * @return True if order was processed successfully and order needs to be delivered
     */
    public boolean requiresDelivery() {
        return this.orderOption.equals(OrderOption.homeDelivery) && this.paid;
    }

    /**
     * @return OrderOption (see enum OrderOption)
     */
    public OrderOption getOrderOption() {
        return this.orderOption;
    }

    /**
     * @return Time of order
     */
    public int getTime() {
        return this.time;
    }

}