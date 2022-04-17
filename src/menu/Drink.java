package menu;

public class Drink extends MenuItem {

    /**
     * @param name of the drink
     * @param price of the drink
     */
    public Drink(String name, double price) {
        super(name);
        this.setPrice(price);
    }

    /**
     * @return Copy of the current object
     */
    public Drink copyOf() {
        return new Drink(this.getName(), this.getPrice());
    }

}
