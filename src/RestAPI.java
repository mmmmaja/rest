// SE_ASS2_Group5
// Marian Chen - 6258052
// Maja Gójska - 6274446

import menu.*;
import order.*;
import restaurant.*;

public class RestAPI {
    private final Restaurant restaurant;
    private final int time;
    private final Order order;

    /**
     * @param restaurant from which the order will be placed
     * @param time When login was registered
     */
    public RestAPI(Restaurant restaurant, int time) {
        this.restaurant = restaurant;
        this.time = time;
        this.order = new Order(this.time, this.restaurant, OrderOption.APIOrder);
    }

    /**
     * @return Current menu of the given restaurant based on the time (to account for discounts at certain hours)
     */
    public Menu getCurrentMenu() {
        return this.restaurant.getCurrentMenu(this.time, false);
    }

    /**
     * @param menuItemName Adds menu item to order
     */
    public void addToOrder(MenuItem menuItemName) {
        this.order.addToOrder(menuItemName);
    }

    /**
     * @return Completed order (i.e., order has been completed and can be relayed back to external ordering website for processing)
     * Assumes that, upon returning the complete order, the rest of the procedure (payment and delivery) depends on the implementation of the external company
     * Procedure without an external company (and solely via the restaurant) is done via Order.java
     */
    public Order completeOrder() {
        return this.order;
    }
}
