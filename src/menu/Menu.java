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
        StringBuilder menu = new StringBuilder();
        int counter = 0;

        menu.append("\ndrinks");
        for (Drink drink : this.drinks) {
            menu.append("\n").append(counter++).append(drink);
        }

        menu.append("\nsideDishes");
        ArrayList<Dish> sideDishes = getDishesOfSpecificType(DishType.sideDish);
        for (Dish dish : sideDishes) {
            menu.append("\n").append(counter++).append(dish);
        }

        menu.append("\nmainDishes");
        ArrayList<Dish> mainDishes = getDishesOfSpecificType(DishType.mainDish);
        for (Dish dish : mainDishes) {
            menu.append("\n").append(counter++).append(dish);
        }

        menu.append("\ndesserts");
        ArrayList<Dish> desserts = getDishesOfSpecificType(DishType.dessert);
        for (Dish dish : desserts) {
            menu.append("\n").append(counter++).append(dish);
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
