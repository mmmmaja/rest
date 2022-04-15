package menu;

import java.util.ArrayList;

/**
 * class that represents the menu of the restaurant
 */
public class Menu {

    private final ArrayList<Drink> drinks;
    private final ArrayList<Dish> dishes;

    public Menu() {
        this.drinks = new ArrayList<>();
        this.dishes = new ArrayList<>();
    }

    /**
     * @param drinks list of all the drinks in the menu
     * @param dishes list of all the dishes in the menu
     */
    public Menu(ArrayList<Drink> drinks, ArrayList<Dish> dishes) {
        this.drinks = drinks;
        this.dishes = dishes;
    }

    /**
     * @param drink to be added to the list of drinks
     */
    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    /**
     * @param dish to be added to the list of dishes
     */
    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    /**
     *
     * @param dishType specific type of dish (see enum options for DishType)
     * @return list of Dish objects of given type
     */
    private ArrayList<Dish> getDishesOfSpecificType(DishType dishType) {
        ArrayList<Dish> dishes = new ArrayList<>();
        for (Dish dish : this.dishes) {
            if (dish.getType().equals(dishType)) {
                dishes.add(dish);
            }
        }
        return dishes;
    }


    public ArrayList<Drink> getDrinks() {
        return this.drinks;
    }


    public ArrayList<Dish> getDishes() {
        return this.dishes;
    }


    public ArrayList<Dish> getSideDishes() {
        return getDishesOfSpecificType(DishType.sideDish);
    }


    public ArrayList<Dish> getMainDishes() {
        return getDishesOfSpecificType(DishType.mainDish);
    }


    public ArrayList<Dish> getDesserts() {
        return getDishesOfSpecificType(DishType.dessert);
    }


    public String toString() {
        StringBuilder menu = new StringBuilder("Menu");
        int counter = 1;

        menu.append("\n\nDrinks");
        for (Drink drink : this.drinks) {
            menu.append("\n").append(counter++).append(". ").append(drink);
        }

        menu.append("\n\nSide Dishes");
        ArrayList<Dish> sideDishes = getDishesOfSpecificType(DishType.sideDish);
        for (Dish dish : sideDishes) {
            menu.append("\n").append(counter++).append(". ").append(dish);
        }

        menu.append("\n\nMain Dishes");
        ArrayList<Dish> mainDishes = getDishesOfSpecificType(DishType.mainDish);
        for (Dish dish : mainDishes) {
            menu.append("\n").append(counter++).append(". ").append(dish);
        }

        menu.append("\n\nDesserts");
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
