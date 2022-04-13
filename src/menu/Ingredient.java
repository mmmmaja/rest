package menu;

public record Ingredient(double price, String name) {

    public double getPrice() {
        return price;
    }

    public Ingredient copyOf() {
        return new Ingredient(this.price, this.name);
    }
}
