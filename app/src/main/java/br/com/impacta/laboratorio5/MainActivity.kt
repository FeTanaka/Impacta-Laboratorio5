package br.com.impacta.laboratorio5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.impacta.laboratorio5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var estado = binding.editTextEstado.text.toString()
            var idadeString = binding.editTextIdade.text.toString()

            var mensagem = verifica(estado, idadeString)
            binding.textView4.text = mensagem
        }
    }

    fun verifica(estado: String, idade: String): String {
        if (estado.length == 0 || idade.length == 0) {
            return "Um dos campos está vazio."
        } else  {
            var credito = calcularCredito(estado, idade.toInt())
            return "Seu crédito liberado foi de R$${credito}"
        }
    }
}

fun calcularCredito(estado: String, idade: Int): Int {
    return when (estado.uppercase()) {
        "SP", "SÃO PAULO", "SAO PAULO" -> if (idade >= 25) 10000 else 5000
        else -> if (idade >= 25) 3000 else 0
    }

//        return if (estado.uppercase() == "SP") {
//            if (idade >= 25) 10000
//            else 5000
//        } else {
//            if (idade >= 25) 3000
//            else 0
//        }

}
