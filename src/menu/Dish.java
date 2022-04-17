package menu;

import java.util.ArrayList;

public class Dish extends MenuItem {

    private final ArrayList<Ingredient> ingredients;
    private final DishType dishType;

    /**
     *
     * @param name of the dish
     * @param ingredients List of all the ingredients in the dish
     * @param dishType Type of the dish (see public enum DishType)
     */
    public Dish(String name, ArrayList<Ingredient> ingredients, DishType dishType) {
        super(name);
        this.ingredients = ingredients;
        this.dishType = dishType;
        computePrice();
    }

    /**
     * Compute the price of the current dish based on the list of the ingredients and their prices
     */
    private void computePrice() {
        double price = 0;
        for (Ingredient ingredient : this.ingredients) {
            price += ingredient.getPrice();
        }
        // Assuming price = cost without considering mark-ups/other costs
        this.setPrice(price);
    }

    /**
     *
     * @return Type of the dish (see DishType enum options)
     */
    public DishType getType() {
        return this.dishType;
    }

    /**
     * @return Copy of the current object
     */
    public Dish copyOf() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for (Ingredient ingredient : this.ingredients) {
            ingredients.add(ingredient.copyOf());
        }
        return new Dish(this.getName(), ingredients, this.getType());
    }
}
