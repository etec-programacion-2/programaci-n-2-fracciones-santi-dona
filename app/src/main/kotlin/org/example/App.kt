package org.example

fun main() {
    val fraccion = Fraccion(3, 4)    
    fraccion.mostrar()    
    fraccion.numerador = 5    
    fraccion.denominador = 6    
    fraccion.mostrar()   
    try {
        fraccion.denominador = 0
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
