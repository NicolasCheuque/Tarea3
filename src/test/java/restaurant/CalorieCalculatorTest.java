package restaurant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

/**
 * Pruebas unitarias para el sistema de gestión de calorías
 */
public class CalorieCalculatorTest {
    private CalorieCalculatorService service;
    
    @BeforeEach
    void setUp() {
        service = new CalorieCalculatorService();
    }
    
    @Test
    void testCalculateValidMenu() {
        Optional<Menu> menu = service.calculateMenuCalories("Gazpacho", "Trucha", "Naranja");
        
        assertTrue(menu.isPresent());
        assertEquals(360, menu.get().getTotalCalories()); // 150 + 160 + 50
    }
    
    @Test
    void testCalculateInvalidMenu() {
        Optional<Menu> menu = service.calculateMenuCalories("Plato Inexistente", "Trucha", "Naranja");
        
        assertFalse(menu.isPresent());
    }
    
    @Test
    void testLowCalorieCombinations() {
        List<Menu> menus = service.getLowCalorieCombinations(400);
        
        assertFalse(menus.isEmpty());
        menus.forEach(menu -> 
            assertTrue(menu.getTotalCalories() <= 400)
        );
    }
    
    @Test
    void testMenuTotalCalories() {
        Dish entrada = new Dish("Test Entrada", DishType.ENTRADA, 100);
        Dish principal = new Dish("Test Principal", DishType.PRINCIPAL, 200);
        Dish postre = new Dish("Test Postre", DishType.POSTRE, 150);
        
        Menu menu = new Menu(entrada, principal, postre);
        assertEquals(450, menu.getTotalCalories());
    }
}
