package delivery;

import order.Order;
import order.OrderOption;
import java.util.ArrayList;

/**
 * this class is responsible for processing of given order
 * contains list of all the employees that deliver the orders
 * if order has to be delivered a deliverer is assigned to the given order
 */
public record OrderProcessing(ArrayList<Deliverer> deliverers) {


    /**
     * @param order to be processed
     * @return true if order was processed successfully and delivery was registered
     * and false if order was denied
     */
    public boolean processOrder(Order order) {

        // payment for the order was not registered and order will be denied
        if (!order.getPaid()) {
            return false;
        }

        // if delivery is required
        if (order.getOrderOption().equals(OrderOption.APIOrder) ||
                order.getOrderOption().equals(OrderOption.homeDelivery)) {

            // find the deliverer that is not currently busy
            for (Deliverer deliverer : this.deliverers) {
                if (!deliverer.getBusy()) {
                    // deliver the order
                    new Delivery(deliverer, order);
                }
            }
        } else {
            // let the waiter deliver the food to the specific table
        }
        return true;
    }
}
