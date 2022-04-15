package delivery;

import order.Order;

/**
 * this class is responsible for handling the delivery of given order
 * has information about the employee that will deliver the order
 */
public record Delivery(Deliverer deliverer, Order order) {

    public Delivery(Deliverer deliverer, Order order) {
        this.deliverer = deliverer;
        this.order = order;

        this.deliverer.setBusy(true);
        deliver();
        this.deliverer.setBusy(false);

        System.out.println("this order was delivered");
    }

    private void deliver() {

    }

}
