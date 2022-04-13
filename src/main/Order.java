package main;

import order.OrderOption;
import restaurant.*;
import java.util.ArrayList;
import menu.*;

public class Order {
    
    private final int hour;
    private final OrderOption orderOption;
    private final Restaurant restaurant;
    private final ArrayList<MenuItem> menuItems;
    private final Menu currentMenu;

    /**
     * Order that customer places
     * @param hour Time (integer hour) that customer places order
     * @param restaurant At which restaurant order is placed
     * @param orderOption Type of order (see enum OrderOption)
     */
    public Order(int hour, Restaurant restaurant, OrderOption orderOption) {
        this.hour = hour;
        this.orderOption = orderOption;
        this.restaurant = restaurant;
        this.menuItems = new ArrayList<>();
        this.currentMenu = restaurant.getCurrentMenu(this);
    }


    public OrderOption getOrderOption() {
        return this.orderOption;
    }


    public int getHour() {
        return hour;
    }


    public void addToOrder(MenuItem menuItem) {
        menuItems.add(menuItem);
    }


    public ArrayList<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public double getTotalPrice() {
        double total = 0;
        for (MenuItem menuItem : menuItems) {
            total += menuItem.getPrice();
        }
        return total;
    }
}
