# Sistema de Gestión de Calorías - "Mi Mejor Comida"

Sistema desarrollado en **Java con programación funcional** para calcular calorías de menús y encontrar combinaciones bajas en calorías.


## Funcionalidades

1. **Calcular calorías de menú específico**: Entrada + Principal + Postre
2. **Mostrar combinaciones bajas en calorías**: Todas las opciones bajo un límite
3. **Ver estadísticas**: Información sobre las 175 combinaciones posibles

## 🍽Base de Conocimientos

### Entradas
- Paella (200), Gazpacho (150), Pasta (300), Ensalada César (180), Sopa de verduras (120)

### Platos Principales  
- Filete de cerdo (400), Pollo asado (280), Bistec a lo pobre (500), Trucha (160), Bacalao (300), Salmón a la plancha (350), Lasaña (450)

### Postres
- Flan (200), Naranja (50), Nueces (500), Yogur (100), Helado (250)

## Programación Funcional Implementada

- **Streams y Lambdas**: `filter()`, `map()`, `flatMap()`, `collect()`
- **Method References**: `Dish::getCalories`, `Menu::getTotalCalories`
- **Optional**: Manejo seguro de valores nulos
- **Composición de funciones**: Combinación de operaciones funcionales
