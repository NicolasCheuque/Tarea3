package restaurant;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Servicio principal para cálculos de calorías usando programación funcional
 */
public class CalorieCalculatorService {
    private final RestaurantDatabase database;
    
    public CalorieCalculatorService() {
        this.database = new RestaurantDatabase();
    }
    
    /**
     * Calcula calorías de un menú específico usando programación funcional
     */
    public Optional<Menu> calculateMenuCalories(String entradaName, String principalName, String postreName) {
        // Función para buscar platos
        Function<String, Optional<Dish>> dishFinder = database::findDishByName;
        
        // Buscar todos los platos usando programación funcional
        Optional<Dish> entrada = dishFinder.apply(entradaName);
        Optional<Dish> principal = dishFinder.apply(principalName);
        Optional<Dish> postre = dishFinder.apply(postreName);
        
        // Validar que todos los platos existan
        if (entrada.isPresent() && principal.isPresent() && postre.isPresent()) {
            return Optional.of(new Menu(entrada.get(), principal.get(), postre.get()));
        }
        
        return Optional.empty();
    }
    
    /**
     * Obtiene combinaciones bajo un límite de calorías
     */
    public List<Menu> getLowCalorieCombinations(int maxCalories) {
        return database.getMenusUnderCalorieLimit(maxCalories);
    }
    
    /**
     * Valida si un plato existe usando programación funcional
     */
    public boolean validateDish(String dishName, DishType expectedType) {
        return database.findDishByName(dishName)
                .map(dish -> dish.getType() == expectedType)
                .orElse(false);
    }
    
    /**
     * Muestra platos disponibles por tipo
     */
    public void showAvailableDishes(DishType type) {
        database.displayDishesByType(type);
    }
    
    /**
     * Obtiene estadísticas usando programación funcional
     */
    public void showStatistics() {
        List<Menu> allCombinations = database.generateAllMenuCombinations();
        
        int totalCombinations = allCombinations.size();
        double averageCalories = allCombinations.stream()
                .mapToInt(Menu::getTotalCalories)
                .average()
                .orElse(0.0);
        
        int minCalories = allCombinations.stream()
                .mapToInt(Menu::getTotalCalories)
                .min()
                .orElse(0);
        
        int maxCalories = allCombinations.stream()
                .mapToInt(Menu::getTotalCalories)
                .max()
                .orElse(0);
        
        System.out.println("\n=== ESTADÍSTICAS DEL RESTAURANTE ===");
        System.out.println("Total de combinaciones posibles: " + totalCombinations);
        System.out.printf("Promedio de calorías: %.1f\n", averageCalories);
        System.out.println("Menú con menos calorías: " + minCalories + " cal");
        System.out.println("Menú con más calorías: " + maxCalories + " cal");
    }
}
