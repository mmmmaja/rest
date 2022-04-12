package menu;

public class Drink extends MenuItem {

    public Drink(String name, double price) {
        super(name);
        this.setPrice(price);
    }

    public Drink copyOf() {
        return new Drink(this.getName(), this.getPrice());
    }

}
