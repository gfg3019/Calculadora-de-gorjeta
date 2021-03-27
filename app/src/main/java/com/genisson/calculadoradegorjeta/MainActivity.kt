
package com.genisson.calculadoradegorjeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var inputValor: TextInputEditText
    private lateinit var textPorcentagem: TextView
    private lateinit var textGorjeta: TextView
    private lateinit var textTotal: TextView
    private lateinit var seekBarGorjeta:SeekBar
    private var porcentagem: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputValor = findViewById(R.id.inputValor)
        textPorcentagem= findViewById(R.id.textPorcentagem)
        textGorjeta = findViewById(R.id.textGorjeta)
        textTotal = findViewById(R.id.textTotal)
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta)
        //Adicionar listenr SeekBar
        seekBarGorjeta.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                porcentagem = progress.toDouble()
                textPorcentagem.text = "${Math.round(porcentagem)}%"
                calcular()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }
    fun calcular(){
        try {
            val valor: String = inputValor.text.toString()
            val valorDigtado = valor.toDouble()
            val gorjeta: Double =  valorDigtado * (porcentagem / 100)
            val total: Double = gorjeta + valorDigtado
            textGorjeta.text = "R$ ${"%.2f".format(gorjeta)}"
            textTotal.text = "R$ ${"%.2f".format(total)}"
        }catch (err: Error){
            err.message
        }

    }

}