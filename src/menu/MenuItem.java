// SE_ASS2_Group5
// Marian Chen - 6258052
// Maja Gójska - 6274446

package menu;

/**
 * parent class for drinks and dishes
 */
public class MenuItem {

    private double price;
    private final String name;

    /**
     * Creates new MenuItem
     * @param name
     */
    public MenuItem(String name) {
        this.name = name;
    }

    /**
     * Setter method
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter method
     * @return price of item
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Getter method
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Displays information about menu item
     */
    public String toString() {
        return this.name + " (" + this.price + " euros)";
    }

}
