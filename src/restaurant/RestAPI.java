package restaurant;

import menu.Menu;
import order.Order;
import order.OrderOption;


public class RestAPI {

    private final Restaurant restaurant;
    private final int time;
    private final Order order;

    /**
     * @param restaurant from which the order will be placed
     * @param time when login was registered
     */
    public RestAPI(Restaurant restaurant, int time) {
        this.restaurant = restaurant;
        this.time = time;
        this.order = new Order(this.time, this.restaurant, OrderOption.APIOrder);
    }

    /**
     * @return current menu of the given restaurant based on the time
     */
    public Menu getCurrentMenu() {
        return this.restaurant.getCurrentMenu(this.time);
    }

    public Order getOrder() {
        return this.order;
    }

    public void addToOrder(String menuItemName) {
        this.order.addToOrder(menuItemName);
    }

    /**
     * TODO
     */
    public boolean completeOrder() {
        return false;
    }


}
