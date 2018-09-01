package br.com.heiderlopes.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import br.com.heiderlopes.primeiroprojeto.extensions.format
import br.com.heiderlopes.primeiroprojeto.utils.ConstantesExtra
import kotlinx.android.synthetic.main.activity_resultado.*
import kotlin.math.roundToInt

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val peso = intent.extras.getString(ConstantesExtra.KEY_PESO)
        val altura = intent.extras.getString(ConstantesExtra.KEY_ALTURA)

        calcularIMC(peso.toDouble(), altura.toDouble())
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun calcularIMC(peso: Double, altura: Double){
        val imc = peso / (altura * altura)

        when (imc){
            in 0..17 -> {
//                tvIMC.setText(imc.toString())
                tvIMC.text = imc.format(0)
                tvDescricao.text = getString(R.string.magreza)
                setImage(R.drawable.magreza)
            }
            in 17.1..18.5 -> {
                tvIMC.text = imc.format(0)
                tvDescricao.text = getString(R.string.abaixo)
                setImage(R.drawable.abaixo)
            }
            in 18.6..24.9 -> {
                tvIMC.text = imc.format(0)
                tvDescricao.text = getString(R.string.ideal)
                setImage(R.drawable.ideal)
            }
            in 25.0..39.9 -> {
                tvIMC.text = imc.format(0)
                tvDescricao.text = getString(R.string.sobre)
                setImage(R.drawable.sobre)
            }
            else -> {
                tvIMC.text = imc.format(0)
                tvDescricao.text = getString(R.string.obesidade)
                setImage(R.drawable.obesidade)
            }
        }

        /*  opcao com if's e else's
        if (imc < 17) {
            //tvIMC.setText(imc.toString())
            tvIMC.text = imc.format(0)
            setImage(R.drawable.magreza)
        } else if (imc < 18.5){
            tvIMC.text = imc.format(0)
            setImage(R.drawable.abaixo)
        } else if (imc < 24.9){
            tvIMC.text = imc.format(0)
            setImage(R.drawable.ideal)
        } else if (imc < 29.9){
            tvIMC.text = imc.format(0)
            setImage(R.drawable.sobre)
        } else {
            tvIMC.text = imc.format(0)
            setImage(R.drawable.obesidade)
        }*/
    }

    private fun setImage(resourceId: Int){
        ivIMC.setImageDrawable(ContextCompat.getDrawable(this, resourceId))
    }
}
