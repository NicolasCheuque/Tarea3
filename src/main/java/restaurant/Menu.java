package restaurant;

/**
 * Representa un menú completo con entrada, plato principal y postre
 */
public class Menu {
    private final Dish entrada;
    private final Dish principal;
    private final Dish postre;
    
    public Menu(Dish entrada, Dish principal, Dish postre) {
        this.entrada = entrada;
        this.principal = principal;
        this.postre = postre;
    }
    
    public Dish getEntrada() { return entrada; }
    public Dish getPrincipal() { return principal; }
    public Dish getPostre() { return postre; }
    
    /**
     * Calcula el total de calorías del menú usando programación funcional
     */
    public int getTotalCalories() {
        return java.util.stream.Stream.of(entrada, principal, postre)
                .mapToInt(Dish::getCalories)
                .sum();
    }
    
    @Override
    public String toString() {
        return String.format(
            "* Entrada: %s\n  Principal: %s\n  Postre: %s\n  TOTAL: %d calorías",
            entrada, principal, postre, getTotalCalories()
        );
    }
}
