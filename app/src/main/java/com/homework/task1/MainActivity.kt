package com.homework.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputTypeNumber = InputType.TYPE_CLASS_NUMBER
        val inputTypeString = InputType.TYPE_CLASS_TEXT
        val inputTypeNumDot = InputType.TYPE_NUMBER_FLAG_DECIMAL

        val name = findViewById<EditText>(R.id.inputName)
        name.inputType = inputTypeString
        val age = findViewById<EditText>(R.id.inputAge)
        age.inputType = inputTypeNumber
        val height = findViewById<EditText>(R.id.inputHeight)
        height.inputType = inputTypeNumber
        val weight = findViewById<EditText>(R.id.inputWeight)
        weight.inputType = inputTypeNumDot

        val resultBtn = findViewById<Button>(R.id.result_btn)

        val calories = findViewById<TextView>(R.id.calories)
        val horoscope = findViewById<TextView>(R.id.horoscope)
        val nds = findViewById<TextView>(R.id.NDS)
        val mortgage = findViewById<TextView>(R.id.mortgage)
        val ndfl = findViewById<TextView>(R.id.NDFL)

        resultBtn.setOnClickListener{
            val n = name.text
            val a = age.text
            val h = height.text
            val w = weight.text

            val intAge = Integer.parseInt(a.toString())
            val intHeight = Integer.parseInt(h.toString())
            val decWeight = Integer.parseInt(w.toString()).toDouble()
            if(intAge in 151 downTo -1){
                if(n.length in 51 downTo -1 && !n.contains("0")&& !n.contains("1")&& !n.contains("2")&&
                    !n.contains("3")&& !n.contains("4")&& !n.contains("5")&& !n.contains("6")&&
                    !n.contains("7")&& !n.contains("8")&& !n.contains("9")) {
                    if(decWeight < 250 && decWeight > 0){
                        if(intHeight in 251 downTo -1){
                            calories.text = "Калории: " + ((intHeight + ceil(decWeight))/2).toString()
                            if(name.text.length > 3 || name.text.contains("д") || name.text.contains("п") ||
                                name.text.contains("а")){
                                horoscope.text = "Гороскоп: "+"lucky day"
                            }else{
                                horoscope.text = R.string.horoscope.toString()+": "+"unlucky day"
                            }
                            nds.text = "НДС: "+ ((intHeight - intAge)*5).toString() + decWeight.toString()
                            ndfl.text = "НДФЛ: "+((intHeight/intAge) + Integer.parseInt(w.toString())).toString()
                            mortgage.text = "Сумма по кредиту: "+(intAge * intHeight).toString()
                        }else{
                            Toast.makeText(this, "Error with height", Toast.LENGTH_LONG).show()
                        }
                    }else{
                        Toast.makeText(this, "Error with weight", Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this, "Error with name", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Error with age", Toast.LENGTH_LONG).show()
            }
        }
    }
}