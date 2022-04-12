package menu;

import java.util.ArrayList;

public class Dish extends MenuItem {

    private final ArrayList<Ingredient> ingredients;
    private final DishType dishType;


    public Dish(String name, ArrayList<Ingredient> ingredients, DishType dishType) {
        super(name);
        this.ingredients = ingredients;
        this.dishType = dishType;
        computePrice();
    }


    private void computePrice() {
        double price = 0;
        for (Ingredient ingredient : this.ingredients) {
            price += ingredient.getPrice();
        }
        // Assuming price = cost without considering mark-ups/other costs
        this.setPrice(price);
    }


    public DishType getType() {
        return this.dishType;
    }


    public Dish copyOf() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for (Ingredient ingredient : this.ingredients) {
            ingredients.add(ingredient.copyOf());
        }
        return new Dish(this.getName(), ingredients, this.getType());
    }
}
