package restaurant;

/**
 * Representa un plato del restaurante con su nombre, categoría y calorías
 */
public class Dish {
    private final String name;
    private final DishType type;
    private final int calories;
    
    public Dish(String name, DishType type, int calories) {
        this.name = name;
        this.type = type;
        this.calories = calories;
    }
    
    public String getName() { return name; }
    public DishType getType() { return type; }
    public int getCalories() { return calories; }
    
    @Override
    public String toString() {
        return String.format("%s (%d cal)", name, calories);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dish dish = (Dish) obj;
        return name.equals(dish.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
