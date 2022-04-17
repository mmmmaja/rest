import menu.Menu;
import order.*;
import restaurant.Restaurant;

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
        return this.restaurant.getCurrentMenu(this.time);
    }

    /**
     * @param menuItemName Adds menu item to order
     */
    public void addToOrder(String menuItemName) {
        this.order.addToOrder(menuItemName);
    }

    /**
     * @return Completed order ()
     * order; the rest (i.e., payment details and delivery depends
     * on implementation of external company)
     */
    public Order completeOrder() {
        return this.order;
    }
}
