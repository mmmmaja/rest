package order;

import restaurant.*;
import java.util.ArrayList;
import menu.*;


/**
 * class having all the information about the order
 */
public class Order {

    private final int time;
    private final OrderOption orderOption;
    private final ArrayList<MenuItem> menuItems;
    private final Menu currentMenu;
    private boolean paid;


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
        this.currentMenu = restaurant.getCurrentMenu(this.time);
        this.paid = false;
    }


    /**
     * add the menuItem to the current order
     * @param menuItemName name of the item
     */
    public void addToOrder(String menuItemName) {
        for (MenuItem menuItem : this.currentMenu.getMenuItem()) {
            if (menuItem.getName().equals(menuItemName)) {
                menuItems.add(menuItem);
            }
        }
    }

    /**
     * @return all the items that this order includes
     */
    public ArrayList<MenuItem> getMenuItems() {
        return this.menuItems;
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
        for (MenuItem menuItem : menuItems) {
            total += menuItem.getPrice();
        }
        return total;
    }

    /**
     * asks the customer to make the payment
     * method to be implemented
     * should update the global boolean paid
     */
    public void requestPayment() {}

    /**
     * @return true if payment for the order was registered
     */
    public boolean getPaid() {
        return this.paid;
    }

    /**
     * @return true if order was processed successfully order needs to be delivered
     */
    public boolean requiresDelivery() {
        return this.orderOption.equals(OrderOption.homeDelivery) && this.paid;
    }

    public OrderOption getOrderOption() {
        return this.orderOption;
    }

    public int getTime() {
        return this.time;
    }

}