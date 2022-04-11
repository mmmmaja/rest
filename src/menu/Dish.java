package menu;

import java.util.ArrayList;

public class Dish extends MenuItem {

    private final ArrayList<Ingredient> ingredients;
    private final String type;


    public Dish(String name, ArrayList<Ingredient> ingredients, String type) {
        super(name);
        this.ingredients = ingredients;
        this.type = type;
        computePrice();
    }

    private void computePrice() {
        double price = 0;
        for (Ingredient ingredient : this.ingredients) {
            price+= ingredient.getPrice();
        }
        this.setPrice(price);
    }

    public String getType() {
        return this.type;
    }
}
