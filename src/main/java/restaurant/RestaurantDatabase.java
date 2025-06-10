package restaurant;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Base de conocimientos del restaurante con todos los platos disponibles
 */
public class RestaurantDatabase {
    private final List<Dish> dishes;
    
    public RestaurantDatabase() {
        this.dishes = initializeDishes();
    }
    
    /**
     * Inicializa la base de datos con todos los platos usando programación funcional
     */
    private List<Dish> initializeDishes() {
        return Arrays.asList(
            // Entradas
            new Dish("Paella", DishType.ENTRADA, 200),
            new Dish("Gazpacho", DishType.ENTRADA, 150),
            new Dish("Pasta", DishType.ENTRADA, 300),
            new Dish("Ensalada César", DishType.ENTRADA, 180),
            new Dish("Sopa de verduras", DishType.ENTRADA, 120),
            
            // Platos principales
            new Dish("Filete de cerdo", DishType.PRINCIPAL, 400),
            new Dish("Pollo asado", DishType.PRINCIPAL, 280),
            new Dish("Bistec a lo pobre", DishType.PRINCIPAL, 500),
            new Dish("Trucha", DishType.PRINCIPAL, 160),
            new Dish("Bacalao", DishType.PRINCIPAL, 300),
            new Dish("Salmón a la plancha", DishType.PRINCIPAL, 350),
            new Dish("Lasaña", DishType.PRINCIPAL, 450),
            
            // Postres
            new Dish("Flan", DishType.POSTRE, 200),
            new Dish("Naranja", DishType.POSTRE, 50),
            new Dish("Nueces", DishType.POSTRE, 500),
            new Dish("Yogur", DishType.POSTRE, 100),
            new Dish("Helado", DishType.POSTRE, 250)
        );
    }
    
    /**
     * Obtiene platos por tipo usando programación funcional
     */
    public List<Dish> getDishesByType(DishType type) {
        return dishes.stream()
                .filter(dish -> dish.getType() == type)
                .collect(Collectors.toList());
    }
    
    /**
     * Busca un plato por nombre usando programación funcional
     */
    public Optional<Dish> findDishByName(String name) {
        return dishes.stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name.trim()))
                .findFirst();
    }
    
    /**
     * Genera todas las combinaciones posibles de menús usando programación funcional
     */
    public List<Menu> generateAllMenuCombinations() {
        List<Dish> entradas = getDishesByType(DishType.ENTRADA);
        List<Dish> principales = getDishesByType(DishType.PRINCIPAL);
        List<Dish> postres = getDishesByType(DishType.POSTRE);
        
        return entradas.stream()
                .flatMap(entrada -> principales.stream()
                        .flatMap(principal -> postres.stream()
                                .map(postre -> new Menu(entrada, principal, postre))))
                .collect(Collectors.toList());
    }
    
    /**
     * Filtra menús por límite de calorías usando programación funcional
     */
    public List<Menu> getMenusUnderCalorieLimit(int maxCalories) {
        return generateAllMenuCombinations().stream()
                .filter(menu -> menu.getTotalCalories() <= maxCalories)
                .sorted(Comparator.comparingInt(Menu::getTotalCalories))
                .collect(Collectors.toList());
    }
    
    /**
     * Muestra platos disponibles por categoría
     */
    public void displayDishesByType(DishType type) {
        System.out.println("\n" + type.getDisplayName() + "s disponibles:");
        getDishesByType(type).forEach(dish -> 
            System.out.println("- " + dish));
    }
}
