package orlando.leyva.asignacion4_calculadora_imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //variables
 var peso: Double=0.0
    var altura: Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//evento del button

        val miBoton: Button= findViewById(R.id.btnCalcular)
        val miTexto: TextView=findViewById(R.id.txResultado)
       val etPeso: EditText=findViewById(R.id.etPeso)
        val etAltura: EditText=findViewById(R.id.etAltura)
        val miEstado: TextView=findViewById(R.id.txEstado)
        miBoton.setOnClickListener {
            peso=etPeso.text.toString().toDouble()
            altura=etAltura.text.toString().toDouble()
            miTexto.text= calcular(String())
            miEstado.text=obtenerPeso()
        }
        }
    //funcion
    fun calcular(total:String):String{

   val total= peso/(altura*altura)
    return total.toString()
    }
    private fun obtenerPeso(): String {
        val imc = peso / (altura * altura)
        val categoria = when {
            imc < 18.5 -> "Bajo peso"
            imc in 18.5..24.9 -> "Normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            imc in 30.0..34.9 -> "Obesidad grado 1"
            imc in 35.0..39.9 -> "Obesidad grado 2"
            imc >= 40.0 -> "Obesidad grado 3"
            else -> "Error en el cálculo"
        }

        return "IMC: Categoría: $categoria"
    }

    }
