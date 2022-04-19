// SE_ASS2_Group5
// Marian Chen - 6258052
// Maja Gójska - 6274446

package menu;

public class Ingredient {

    private double price;
    private String name;

    public Ingredient(double price, String name) {
        this.price = price;
        this.name = name;
    }


    /**
     * Returns price of the ingredient
     * @return Price of the ingredient
     */
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

     /**
     * @return Copy of the current object
     */
    public Ingredient copyOf() {
        return new Ingredient(this.price, this.name);
    }
}
