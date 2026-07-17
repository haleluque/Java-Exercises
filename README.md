# Algoritmos

Repositorio de práctica de problemas de algoritmos y estructuras de datos típicos de entrevistas técnicas.

El objetivo es repasar patrones comunes (arrays, hashing, two pointers, sliding window, matrices, sorting, streams, etc.) y documentar el razonamiento junto al código.

## Estructura

### `src/main/java/com/haleluqe/algorithms/`

Soluciones a problemas clásicos de entrevistas (arrays, hashing, sliding window, etc.). Cada clase contiene la implementación del algoritmo.

| Clase | Tema |
|-------|------|
| `ContainsDuplicate` | Detectar duplicados en un array |
| `MostFrequentElement` | Elemento más frecuente |
| `PairSum` / `PairSum2` | Pares que suman un objetivo |
| `BestTimeToBuyAndSellStocks` | Máximo beneficio comprando/vendiendo acciones |
| `ContainerWithMostWater` | Contenedor con más agua |
| `LongestConsecutiveSequence` | Secuencia consecutiva más larga |
| `LongestRepeatingCharacReplacement` | Reemplazo de caracteres repetidos |
| `MinimumWindowSubString` | Substring ventana mínima |
| `ValidSudoku` | Validar un tablero de Sudoku |

### `src/main/java/com/haleluqe/problems/`

Ejercicios tipo challenge (p. ej. HackerRank). Cada uno vive en su propio paquete con:

- la solución en Java
- un `PROBLEM.md` con el enunciado

| Paquete | Problema |
|---------|----------|
| `plus_minus` | Ratios de positivos, negativos y ceros |
| `min_max_sum` | Suma mínima y máxima de 4 de 5 enteros |
| `time_convertion` | Conversión de hora 12h a 24h |
| `lonely_integer` | Elemento único en un array de pares |
| `diagonal_difference` | Diferencia absoluta entre diagonales |
| `counting_sort_1` | Array de frecuencias (counting sort) |
| `flipping_matrix` | Maximizar suma del cuadrante superior izquierdo |

## Cómo correr

Proyecto Maven con Java. Compila y ejecuta las clases `main` de cada paquete o clase según el ejercicio.
