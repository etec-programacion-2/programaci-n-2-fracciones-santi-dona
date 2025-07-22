package org.example

fun main() {
    println("--- Operaciones con Fracciones ---\n")

    // Fracciones de prueba
    val fraccionA = Fraccion(1, 2)
    val fraccionB = Fraccion(3, 4)
    val fraccionC = Fraccion(2, 5)

    // Mostrar fracciones
    println("Fracciones iniciales:")
    print("A = "); fraccionA.mostrar()
    print("B = "); fraccionB.mostrar()
    print("C = "); fraccionC.mostrar()

    // Operaciones
    println("\nResultados de operaciones:")
    
    val sumaAB = fraccionA + fraccionB
    print("A + B = "); sumaAB.mostrar()  // 1/2 + 3/4 = 5/4

    val restaBC = fraccionB - fraccionC
    print("B - C = "); restaBC.mostrar()  // 3/4 - 2/5 = 7/20

    val multiplicacionAB = fraccionA * fraccionB
    print("A * B = "); multiplicacionAB.mostrar()  // 1/2 * 3/4 = 3/8

    val divisionAB = fraccionA / fraccionB
    print("A / B = "); divisionAB.mostrar()  // 1/2 / 3/4 = 2/3

    // Comparaciones
    println("\nComparaciones:")
    println("A es mayor que B: ${fraccionA.esMayor(fraccionB)}")  // false
    println("A es menor que B: ${fraccionA.esMenor(fraccionB)}")  // true

    // Conversión a decimal
    println("\nConversión a decimal:")
    println("A en decimal: ${fraccionA.aDecimal()}")  // 0.5
    println("B en decimal: ${fraccionB.aDecimal()}")  // 0.75

    // Crear fracción desde decimal
    val fraccionDesdeDecimal = Fraccion.desdeDecimal(0.75)
    println("\nFracción desde decimal 0.75:")
    fraccionDesdeDecimal.mostrar()  // Debe mostrar 3/4

    // Caso especial: simplificación
    val fraccionD = Fraccion(4, 8)
    println("\nSimplificación automática:")
    print("4/8 simplificado = "); fraccionD.mostrar()  // Debe mostrar 1/2

    // Validación de errores
    println("\nValidación de denominador cero:")
    try {
        Fraccion(3, 0)
    } catch (e: IllegalArgumentException) {
        println("Error al crear fracción: ${e.message}")
    }

    try {
        val fraccionValida = Fraccion(1, 2)
        fraccionValida.denominador = 0
    } catch (e: IllegalArgumentException) {
        println("Error al modificar denominador: ${e.message}")
    }

    // Validación de división por cero
    try {
        val fraccionE = Fraccion(1, 2)
        val fraccionF = Fraccion(0, 1) // Numerador cero
        fraccionE / fraccionF
    } catch (e: IllegalArgumentException) {
        println("Error al dividir: ${e.message}")  // Debe mostrar error
    }
}
