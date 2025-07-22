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
        // Manejo de fracciones negativas
        if (_denominador < 0) {
            _numerador = -_numerador
            _denominador = -_denominador
        }
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

    operator fun times(otra: Fraccion): Fraccion {
        return Fraccion(
            numerador * otra.numerador,
            denominador * otra.denominador
        ).simplificar()
    }

    operator fun div(otra: Fraccion): Fraccion {
        require(otra.numerador != 0) { "No se puede dividir por una fracción con numerador cero" }
        return Fraccion(
            numerador * otra.denominador,
            denominador * otra.numerador
        ).simplificar()
    }

    operator fun compareTo(otra: Fraccion): Int {
        val diferencia = numerador * otra.denominador - otra.numerador * denominador
        return when {
            diferencia > 0 -> 1
            diferencia < 0 -> -1
            else -> 0
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        return this.numerador == other.numerador && this.denominador == other.denominador
    }

    fun esMayor(otra: Fraccion): Boolean {
        return this > otra
    }

    fun esMenor(otra: Fraccion): Boolean {
        return this < otra
    }

    fun aDecimal(): Double {
        return numerador.toDouble() / denominador.toDouble()
    }

    companion object {
        fun desdeDecimal(decimal: Double): Fraccion {
            val tolerancia = 1E-10
            var numerador = decimal
            var denominador = 1.0
            while (abs(numerador - Math.round(numerador)) > tolerancia) {
                numerador *= 10
                denominador *= 10
            }
            return Fraccion(numerador.toInt(), denominador.toInt()).simplificar()
        }
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

