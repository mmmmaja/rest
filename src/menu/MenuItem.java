package menu;


public class MenuItem {

    private double price;
    private String name;

    public MenuItem(String name) {}

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + "( "+this.price+" euro )";
    }

}
