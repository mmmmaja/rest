package menu;

import java.util.ArrayList;


/**
 * TODO display content
 * getDrinks(), getSideDishes(), getMainDishes(), getDesserts()
 */
public class Menu {

    private final ArrayList<Drink> drinks;
    private final ArrayList<Dish> dishes;

    public Menu() {
        this.drinks = new ArrayList<>();
        this.dishes = new ArrayList<>();
    }


    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }


    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }


    private ArrayList<Dish> getDishesOfSpecificType(DishType dishType) {
        ArrayList<Dish> dishes = new ArrayList<>();
        for (Dish dish : this.dishes) {
            if (dish.getType().equals(dishType)) {
                dishes.add(dish);
            }
        }
        return dishes;
    }


    public String toString() {
        StringBuilder menu = new StringBuilder("Menu");
        int counter = 0;

        menu.append("\n\ndrinks");
        for (Drink drink : this.drinks) {
            menu.append("\n").append(counter++).append(". ").append(drink);
        }

        menu.append("\n\nsideDishes");
        ArrayList<Dish> sideDishes = getDishesOfSpecificType(DishType.sideDish);
        for (Dish dish : sideDishes) {
            menu.append("\n").append(counter++).append(". ").append(dish);
        }

        menu.append("\n\nmainDishes");
        ArrayList<Dish> mainDishes = getDishesOfSpecificType(DishType.mainDish);
        for (Dish dish : mainDishes) {
            menu.append("\n").append(counter++).append(". ").append(dish);
        }

        menu.append("\n\ndesserts");
        ArrayList<Dish> desserts = getDishesOfSpecificType(DishType.dessert);
        for (Dish dish : desserts) {
            menu.append("\n").append(counter++).append(". ").append(dish);
        }

        return menu.toString();
    }


    public Menu copyOf() {
        Menu menu = new Menu();
        for (Drink drink : this.drinks) {
            menu.addDrink(drink.copyOf());
        }
        for (Dish dish : this.dishes) {
            menu.addDish(dish.copyOf());
        }
        return menu;
    }


}
