package menu;

import java.util.ArrayList;

/**
 * Class that represents the menu of the restaurant
 */
public class Menu {
    private final ArrayList<MenuItem> menuItems;

    /**
     * Creates empty menu (ArrayList)
     */
    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    /**
     * Create menu with list of menu items in the constructor
     * @param menuItems in menu
     */
    public Menu(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    /**
     * Add menu item
     * @param menuItem
     */
    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    /**
     * Get list of menu items
     * @return
     */
    public ArrayList<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    /**
     * Returns list of menu items of a specific dish type
     * @param dishType Specific type of dish (see public enum DishType)
     * @return List of Dish objects of given type
     */
    private ArrayList<Dish> getDishesOfSpecificType(DishType dishType) {
        ArrayList<Dish> dishes = new ArrayList<>();
        for (MenuItem menuItem : this.menuItems) {
            if (menuItem instanceof Dish) {
                if (((Dish) menuItem).getType().equals(dishType)) {
                    dishes.add((Dish) menuItem);
                }
            }
        }
        return dishes;
    }

    /**
     * Gets list of side dishes
     * @return List of side dishes
     */
    public ArrayList<Dish> getSideDishes() {
        return getDishesOfSpecificType(DishType.sideDish);
    }

    /**
     * Gets list of main dishes
     * @return List of main dishes
     */
    public ArrayList<Dish> getMainDishes() {
        return getDishesOfSpecificType(DishType.mainDish);
    }

    /**
     * Gets list of desserts
     * @return List of desserts
     */
    public ArrayList<Dish> getDesserts() {
        return getDishesOfSpecificType(DishType.dessert);
    }

    /**
     * Returns contents of menu
     */
    public String toString() {
        StringBuilder menu = new StringBuilder("Menu");
        int counter = 1;

        menu.append("\n\nDrinks");
        for (MenuItem menuItem : this.menuItems) {
            if (menuItem instanceof Drink) {
                menu.append("\n").append(counter++).append(". ").append(menuItem);
            }
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

    /**
     * Creates copy of the menu
     * @return menu
     */
    public Menu copyOf() {
        Menu menu = new Menu();
        for (MenuItem menuItem : this.menuItems) {
            if (menuItem instanceof Drink) {
                menu.addMenuItem((Drink) menuItem);
            }
            else {
                menu.addMenuItem((Dish) menuItem);
            }
        }
        return menu;
    }
}
