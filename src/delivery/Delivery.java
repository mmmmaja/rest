package delivery;

import order.Order;

import java.util.ArrayList;

/**
 * this class is responsible for handling the delivery of given order
 * has information about the employee that will deliver the order
 */
public class Delivery {

    private final ArrayList<Deliverer> deliverers;

    public Delivery(ArrayList<Deliverer> deliverers) {
        this.deliverers = deliverers;
    }

    public void deliver(Order order) {
        for (Deliverer deliverer : this.deliverers) {
            if (!deliverer.getBusy()) {
                // deliver the order
            }
        }
    }

}
