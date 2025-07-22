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

    val sumaAC = fraccionA + fraccionC
    print("A + C = "); sumaAC.mostrar()  // 1/2 + 2/5 = 9/10

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
}
