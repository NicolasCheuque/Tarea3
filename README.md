# Sistema de Gestión de Calorías - "Mi Mejor Comida"

Sistema desarrollado en **Java con programación funcional** para calcular calorías de menús y encontrar combinaciones bajas en calorías.

## 🚀 Cómo Ejecutar

### Opción 1: Con Maven (Recomendado)
\`\`\`bash
# Compilar y ejecutar
mvn clean compile exec:java
\`\`\`

### Opción 2: Compilación Manual
\`\`\`bash
# Compilar
javac -d target/classes src/main/java/restaurant/*.java

# Ejecutar
java -cp target/classes restaurant.RestaurantApp
\`\`\`

### Ejecutar Pruebas
\`\`\`bash
mvn test
\`\`\`

## 📋 Funcionalidades

1. **Calcular calorías de menú específico**: Entrada + Principal + Postre
2. **Mostrar combinaciones bajas en calorías**: Todas las opciones bajo un límite
3. **Ver estadísticas**: Información sobre las 175 combinaciones posibles

## 🍽️ Base de Conocimientos

### Entradas
- Paella (200), Gazpacho (150), Pasta (300), Ensalada César (180), Sopa de verduras (120)

### Platos Principales  
- Filete de cerdo (400), Pollo asado (280), Bistec a lo pobre (500), Trucha (160), Bacalao (300), Salmón a la plancha (350), Lasaña (450)

### Postres
- Flan (200), Naranja (50), Nueces (500), Yogur (100), Helado (250)

## 🔧 Programación Funcional Implementada

- **Streams y Lambdas**: `filter()`, `map()`, `flatMap()`, `collect()`
- **Method References**: `Dish::getCalories`, `Menu::getTotalCalories`
- **Optional**: Manejo seguro de valores nulos
- **Composición de funciones**: Combinación de operaciones funcionales

### Ejemplo de Código Funcional
\`\`\`java
// Generar todas las combinaciones
return entradas.stream()
    .flatMap(entrada -> principales.stream()
        .flatMap(principal -> postres.stream()
            .map(postre -> new Menu(entrada, principal, postre))))
    .collect(Collectors.toList());

// Filtrar por límite de calorías
return generateAllMenuCombinations().stream()
    .filter(menu -> menu.getTotalCalories() <= maxCalories)
    .sorted(Comparator.comparingInt(Menu::getTotalCalories))
    .collect(Collectors.toList());
\`\`\`

## 📱 Ejemplo de Uso

\`\`\`
BIENVENIDO A "MI MEJOR COMIDA"
==========================================

--- MENÚ PRINCIPAL ---
1. Calcular calorías de un menú específico
2. Mostrar combinaciones bajas en calorías
3. Ver estadísticas del restaurante
4. Salir

Seleccione una opción (1-4): 2

--- MENÚS BAJOS EN CALORÍAS ---
Ingrese el máximo de calorías deseado: 500

Combinaciones disponibles con menos de 500 calorías:
(23 opciones encontradas)

* Entrada: Sopa de verduras (120 cal)
  Principal: Trucha (160 cal)
  Postre: Naranja (50 cal)
  TOTAL: 330 calorías
\`\`\`

## ✅ Requisitos Cumplidos

- ✅ Java con programación funcional
- ✅ Base de conocimientos completa (todos los platos)
- ✅ Cálculo de calorías por menú
- ✅ Combinaciones bajas en calorías
- ✅ Uso de lambdas y mapping de funciones
- ✅ Interfaz interactiva con manejo de errores
- ✅ Todas las calorías según tabla especificada
# Tarea3
# Tarea3
# Tarea3
