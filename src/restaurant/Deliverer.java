package restaurant;

/**
 * class representing an employee that delivers the food order in the restaurant
 * we assumed that each deliverer works for the specific restaurant
 */
public class Deliverer {

    private final String delivererID;

    // when deliverer is working and can't deliver order at the moment boolean busy is set to true
    // once delivery is done busy boolean is set back to false
    private boolean busy;

    /**
     * @param delivererID unique String representing the deliverer
     */
    public Deliverer(String delivererID) {
        this.delivererID = delivererID;
        this.busy = false;
    }

    public boolean getBusy() {
        return this.busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public String toString() {
        return "ID: " + delivererID;
    }

}
