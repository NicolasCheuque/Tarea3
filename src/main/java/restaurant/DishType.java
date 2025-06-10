package restaurant;

/**
 * Enumera los tipos de platos disponibles
 */
public enum DishType {
    ENTRADA("Entrada"),
    PRINCIPAL("Plato Principal"), 
    POSTRE("Postre");
    
    private final String displayName;
    
    DishType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
