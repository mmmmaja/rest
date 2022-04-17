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
     * 
     * @param menuItems
     */
    public Menu(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public ArrayList<MenuItem> getMenuItem() {
        return this.menuItems;
    }


    /**
     *
     * @param dishType specific type of dish (see enum options for DishType)
     * @return list of Dish objects of given type
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
