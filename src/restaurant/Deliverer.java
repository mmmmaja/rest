// SE_ASS2_Group5
// Marian Chen - 6258052
// Maja Gójska - 6274446

package restaurant;

/**
 * Class representing an employee that delivers the food order in the restaurant
 * Based on the assumption that each deliverer works for the specific restaurant (i.e., separate from deliverers of an external ordering website)
 */
public class Deliverer {
    private final String delivererID;
    // When deliverer is working and cannot deliver order at the moment boolean busy is set to true
    // Once delivery is done, boolean busy is set back to false
    private boolean busy;

    /**
     * @param delivererID Unique String representing the deliverer
     */
    public Deliverer(String delivererID) {
        this.delivererID = delivererID;
        this.busy = false;
    }

    /**
     * @return True if deliverer is unavailable, false if deliverer can make a delivery
     */
    public boolean getBusy() {
        return this.busy;
    }

    /**
     * @param busy Status of deliverer
     */
    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    /**
     * Shows status of specific deliverer
     */
    public String toString() {
        return "ID: " + delivererID;
    }

}
