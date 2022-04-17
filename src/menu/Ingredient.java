package menu;

public record Ingredient(double price, String name) {
    /**
     * Returns price of the ingredient
     * @return Price of the ingredient
     */
    public double getPrice() {
        return price;
    }

     /**
     * @return Copy of the current object
     */
    public Ingredient copyOf() {
        return new Ingredient(this.price, this.name);
    }
}
