package com.bemal.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun butNumberEvent(view: View){
        if(isNewOpp){
            showNumber.setText("")
        }

        isNewOpp = false
        val butSelect = view as Button
        var butClickValue: String = showNumber.text.toString()

        when(butSelect.id){
            but0.id -> {
                butClickValue += "0"
            }
            but1.id -> {
                butClickValue += "1"
            }
            but2.id -> {
                butClickValue += "2"
            }
            but3.id -> {
                butClickValue += "3"
            }
            but4.id -> {
                butClickValue += "4"
            }
            but5.id -> {
                butClickValue += "5"
            }
            but6.id -> {
                butClickValue += "6"
            }
            but7.id -> {
                butClickValue += "7"
            }
            but8.id -> {
                butClickValue += "8"
            }
            but9.id -> {
                butClickValue += "9"
            }
            butDot.id -> {
                if(numberOfDots == 0){
                    butClickValue += "."
                }
                numberOfDots++
            }
            butPlusMin.id -> {
                butClickValue += "-" + butClickValue
            }
        }

        showNumber.setText(butClickValue)
    }

    var op = "*"
    var oldNumber = ""
    var isNewOpp = true
    var numberOfDots: Int = 0

    fun butOppEvent(view: View){
        var butSelect = view as Button

        when(butSelect.id){
            butMulti.id -> {
                op = "*"
            }
            butDiv.id -> {
                op = "/"
            }
            butSub.id -> {
                op = "-"
            }
            butAdd.id -> {
                op = "+"
            }
        }
        oldNumber = showNumber.text.toString()
        isNewOpp = true
    }

    fun butEqualEvent(view: View){
        val newNumber = showNumber.text.toString()
        var finalNumber: Double?=null
        when(op){
            "*" -> {
                finalNumber = newNumber.toDouble() * oldNumber.toDouble()
            }
            "+" -> {
                finalNumber = newNumber.toDouble() + oldNumber.toDouble()
            }
            "-" -> {
                finalNumber =  oldNumber.toDouble() - newNumber.toDouble()
            }
            "/" -> {
                if(newNumber.toInt() != 0){
                    finalNumber = oldNumber.toDouble() / newNumber.toDouble()
                }else{
                    finalNumber = 0.0
                    Toast.makeText(this,"you Can not divide from 0",Toast.LENGTH_LONG).show()
                }
            }
        }
        numberOfDots = 0
        showNumber.setText(finalNumber.toString())
        isNewOpp = true
    }

    fun clickPerEvent(view: View){
        if(showNumber.text.toString().length != 0){
            val number: Double = showNumber.text.toString().toDouble() / 100
            showNumber.setText(number.toString())
        }else{
            Toast.makeText(this,"enter Number Before Percentage",Toast.LENGTH_LONG).show()
        }
    }

    fun butClearEvent(view: View){
        showNumber.setText("")
        numberOfDots = 0
    }
}
