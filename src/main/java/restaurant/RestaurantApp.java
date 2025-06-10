package restaurant;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Aplicación principal del sistema de gestión de calorías
 */
public class RestaurantApp {
    private final CalorieCalculatorService service;
    private final Scanner scanner;
    
    public RestaurantApp() {
        this.service = new CalorieCalculatorService();
        this.scanner = new Scanner(System.in);
    }
    
    public void run() {
        showWelcome();
        
        boolean running = true;
        while (running) {
            showMainMenu();
            int option = getMenuOption();
            
            switch (option) {
                case 1 -> calculateSpecificMenu();
                case 2 -> showLowCalorieCombinations();
                case 3 -> showStatistics();
                case 4 -> {
                    System.out.println("\n¡Gracias por visitar Mi Mejor Comida!");
                    running = false;
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        
        scanner.close();
    }
    
    private void showWelcome() {
        System.out.println("==========================================");
        System.out.println("    BIENVENIDO A \"MI MEJOR COMIDA\"");
        System.out.println("==========================================");
    }
    
    private void showMainMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Calcular calorías de un menú específico");
        System.out.println("2. Mostrar combinaciones bajas en calorías");
        System.out.println("3. Ver estadísticas del restaurante");
        System.out.println("4. Salir");
        System.out.print("\nSeleccione una opción (1-4): ");
    }
    
    private int getMenuOption() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Calcula calorías de un menú específico usando programación funcional
     */
    private void calculateSpecificMenu() {
        System.out.println("\n--- CÁLCULO DE CALORÍAS ---");
        
        // Función para solicitar plato con validación
        Supplier<String> dishInputSupplier = () -> {
            String input = scanner.nextLine().trim();
            return input.isEmpty() ? null : input;
        };
        
        // Mostrar platos disponibles
        service.showAvailableDishes(DishType.ENTRADA);
        System.out.print("\nIngrese el nombre de la entrada: ");
        String entrada = dishInputSupplier.get();
        
        service.showAvailableDishes(DishType.PRINCIPAL);
        System.out.print("\nIngrese el nombre del plato principal: ");
        String principal = dishInputSupplier.get();
        
        service.showAvailableDishes(DishType.POSTRE);
        System.out.print("\nIngrese el nombre del postre: ");
        String postre = dishInputSupplier.get();
        
        // Calcular usando programación funcional
        Optional<Menu> menu = service.calculateMenuCalories(entrada, principal, postre);
        
        menu.ifPresentOrElse(
            m -> {
                System.out.println("\n=== RESUMEN DEL MENÚ ===");
                System.out.println(m);
            },
            () -> {
                System.out.println("\nError: Uno o más platos no fueron encontrados.");
                System.out.println("Verifique los nombres e intente nuevamente.");
            }
        );
    }
    
    /**
     * Muestra combinaciones bajas en calorías usando programación funcional
     */
    private void showLowCalorieCombinations() {
        System.out.println("\n--- MENÚS BAJOS EN CALORÍAS ---");
        System.out.print("Ingrese el máximo de calorías deseado: ");
        
        try {
            int maxCalories = Integer.parseInt(scanner.nextLine().trim());
            
            if (maxCalories <= 0) {
                System.out.println("El límite de calorías debe ser mayor a 0.");
                return;
            }
            
            List<Menu> lowCalorieMenus = service.getLowCalorieCombinations(maxCalories);
            
            if (lowCalorieMenus.isEmpty()) {
                System.out.println("\nNo hay combinaciones disponibles con menos de " + maxCalories + " calorías.");
            } else {
                System.out.println("\nCombinaciones disponibles con menos de " + maxCalories + " calorías:");
                System.out.println("(" + lowCalorieMenus.size() + " opciones encontradas)\n");
                
                // Mostrar usando programación funcional
                lowCalorieMenus.forEach(menu -> {
                    System.out.println(menu);
                    System.out.println();
                });
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
        }
    }
    
    /**
     * Muestra estadísticas del restaurante
     */
    private void showStatistics() {
        service.showStatistics();
    }
    
    public static void main(String[] args) {
        new RestaurantApp().run();
    }
}
