package br.com.impacta.laboratorio5

fun main() {
    var estado: String = "SP"
    var idade: Int = 33
    var credito:Int = 0

    credito = if (estado == "SP") {
        if (idade >= 25) 10000
        else 500
    } else {
        if (idade >= 25) 3000
        else 0
    }

    println("O cliente teve um crédito liberado de R$$credito")
}