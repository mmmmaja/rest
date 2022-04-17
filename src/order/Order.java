package order;

import order.OrderOption;
import restaurant.*;
import java.util.ArrayList;
import menu.*;


/**
 * class having all the information about the order
 */
public class Order {

    private final int hour;
    private final OrderOption orderOption;
    private final ArrayList<MenuItem> orders;
    private final Menu currentMenu;
    private boolean paid;
    private boolean toBeDelivered;

    /**
     * Order that customer places
     * @param hour Time (integer hour) that customer places order
     * @param restaurant At which restaurant order is placed
     * @param orderOption Type of order (see enum OrderOption)
     */
    public Order(int hour, Restaurant restaurant, OrderOption orderOption) {
        this.hour = hour;
        this.orderOption = orderOption;
        this.orders = new ArrayList<>();
        this.currentMenu = restaurant.getCurrentMenu(this.hour);
        this.paid = false;
    }

    public OrderOption getOrderOption() {
        return this.orderOption;
    }


    public int getHour() {
        return hour;
    }


    /**
     * add the menuItem to the current order
     * @param menuItemName name of the item
     */
    public void addToOrder(String menuItemName) {
        for (MenuItem menuItem : this.currentMenu.getMenuItem()) {
            if (menuItem.getName().equals(menuItemName)) {
                orders.add(menuItem);
            }
        }
    }

    /**
     * @return all the items that this order includes
     */
    public ArrayList<MenuItem> getMenuItems() {
        return this.orders;
    }

    /**
     * @return menu with updated prices based on the special offers and happy hours
     */
    public Menu getCurrentMenu() {
        return this.currentMenu;
    }

    /**
     * @return total price of the order including special offers and happy hours
     */
    public double getTotalPrice() {
        double total = 0;
        for (MenuItem menuItem : orders) {
            total += menuItem.getPrice();
        }
        return total;
    }

    /**
     * asks the customer to make the payment
     */
    public void requestPayment() {
        System.out.println("\nTo be paid: " + this.getTotalPrice());
        this.paid = true;
    }

    /**
     * @return true if payment for the order was registered
     */
    public boolean getPaid() {
        return this.paid;
    }

    /**
     * @return true if order was processed successfully and delivery was registered
     * and false if order was denied
     */
    public boolean toBeDelivered() {

        // payment for the order was not registered and order will be denied
        if (!this.paid) {
            return false;
        }

        // if delivery is required
        return this.orderOption.equals(OrderOption.APIOrder) ||
                this.orderOption.equals(OrderOption.homeDelivery);
    }

}