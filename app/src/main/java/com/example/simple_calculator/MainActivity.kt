package com.example.simple_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber1 = findViewById(R.id.editTextText)
        editTextNumber2 = findViewById(R.id.editTextText2)
        resultTextView = findViewById(R.id.textView2)

        val addButton: Button = findViewById(R.id.button8)
        val subtractButton: Button = findViewById(R.id.button9)
        val multiplyButton: Button = findViewById(R.id.button10)
        val divideButton: Button = findViewById(R.id.button11)

        addButton.setOnClickListener {
            calculateResult('+')
        }

        subtractButton.setOnClickListener {
            calculateResult('-')
        }

        multiplyButton.setOnClickListener {
            calculateResult('*')
        }

        divideButton.setOnClickListener {
            calculateResult('/')
        }
        var button = findViewById(R.id.button_other) as Button
        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun calculateResult(operator: Char) {
        val number1Str = editTextNumber1.text.toString()
        val number2Str = editTextNumber2.text.toString()

        if (number1Str.isEmpty() || number2Str.isEmpty()) {
            resultTextView.text = "Please enter two numbers"
            return
        }

        val number1 = number1Str.toDouble()
        val number2 = number2Str.toDouble()

        val result = when (operator) {
            '+' -> number1 + number2
            '-' -> number1 - number2
            '*' -> number1 * number2
            '/' -> {
                if (number2 == 0.0) {
                    "Division by zero not allowed"
                } else {
                    number1 / number2
                }
            }
            else -> {
                "Invalid operator"
            }
        }

        resultTextView.text = "$result"
    }
}


