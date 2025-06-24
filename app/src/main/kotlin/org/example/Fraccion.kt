package org.example

class Fraccion(numerador: Int = 0, denominador: Int = 1) {
    var numerador: Int = numerador
        set(value) { field = value }
    var denominador: Int = denominador
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            field = value
        }
    init {
        if (denominador == 0) throw IllegalArgumentException("El denominador no puede ser cero")
    }
    fun mostrar() {
        println("$numerador/$denominador")
    }
}