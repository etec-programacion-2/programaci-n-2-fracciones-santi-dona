package org.example

import kotlin.math.abs

class Fraccion(private var _numerador: Int = 0, private var _denominador: Int = 1) {
    var numerador: Int
        get() = _numerador
        set(value) { _numerador = value }

    var denominador: Int
        get() = _denominador
        set(value) {
            require(value != 0) { "El denominador no puede ser cero" }
            _denominador = value
        }

    init {
        require(_denominador != 0) { "El denominador no puede ser cero" }
    }

    operator fun plus(otra: Fraccion): Fraccion {
        return Fraccion(
            numerador * otra.denominador + otra.numerador * denominador,
            denominador * otra.denominador
        ).simplificar()
    }

    operator fun minus(otra: Fraccion): Fraccion {
        return Fraccion(
            numerador * otra.denominador - otra.numerador * denominador,
            denominador * otra.denominador
        ).simplificar()
    }

    private fun simplificar(): Fraccion {
        val mcd = calcularMCD(abs(numerador), abs(denominador))
        return Fraccion(numerador / mcd, denominador / mcd)
    }

    private fun calcularMCD(a: Int, b: Int): Int = if (b == 0) a else calcularMCD(b, a % b)

    fun mostrar() {
        println("${numerador}/${denominador}")
    }

    override fun toString(): String = "${numerador}/${denominador}"
}
