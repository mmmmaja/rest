package menu;

import java.util.ArrayList;


/**
 * TODO display content
 * getDrinks(), getSideDishes(), getMainDishes(), getDesserts()
 */
public class Menu {

    private ArrayList<Drink> drinks;
    private ArrayList<Dish> dishes;

    public Menu() {}

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }


    public ArrayList<Dish> getDishesType(String type) {
        ArrayList<Dish> dishes = new ArrayList<>();
        for (Dish dish : this.dishes) {
            if (dish.getType().equals(type)) {
                dishes.add(dish);
            }
        }
        return dishes;
    }


}
