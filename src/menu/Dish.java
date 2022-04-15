package menu;

import java.util.ArrayList;

public class Dish extends MenuItem {

    private final ArrayList<Ingredient> ingredients;
    private final DishType dishType;

    /**
     *
     * @param name of the dish
     * @param ingredients list of all the ingredients that the dish consists of
     * @param dishType type of the dish (see DishType enum options)
     */
    public Dish(String name, ArrayList<Ingredient> ingredients, DishType dishType) {
        super(name);
        this.ingredients = ingredients;
        this.dishType = dishType;
        computePrice();
    }

    /**
     * compute the price of the current dish based on the list of the ingredients and their prices
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
     * @return type of the dish (see DishType enum options)
     */
    public DishType getType() {
        return this.dishType;
    }

    /**
     * @return copy of the current object
     */
    public Dish copyOf() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for (Ingredient ingredient : this.ingredients) {
            ingredients.add(ingredient.copyOf());
        }
        return new Dish(this.getName(), ingredients, this.getType());
    }
}
