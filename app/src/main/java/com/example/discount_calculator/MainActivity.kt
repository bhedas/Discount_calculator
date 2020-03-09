package com.example.discount_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.SeekBar.OnSeekBarChangeListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var payment = findViewById<EditText>(R.id.payment)
        var seekbar = findViewById<SeekBar>(R.id.seekBar)
        var discount = findViewById<TextView>(R.id.discount)
        var result = findViewById<TextView>(R.id.result)
        var convert = findViewById<Button>(R.id.button)
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                discount.text=progress.toString()+"%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        convert.setOnClickListener(View.OnClickListener {
            try {
                var value=payment.text.toString().toInt()
                var seekbarvalue=seekbar.progress
                var calculate=value-(value*seekbarvalue/100)
                result.text=calculate.toString()
            }
            catch (e:Exception){
                result.text="Not valid amount"
            }



        })
    }
}

