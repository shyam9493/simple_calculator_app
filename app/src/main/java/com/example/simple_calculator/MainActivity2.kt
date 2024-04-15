package com.example.simple_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val textViewResult: TextView = findViewById(R.id.textView2)
        val buttonPrime: Button = findViewById(R.id.button8)
        val buttonEven: Button = findViewById(R.id.button9)
        val buttonFactorial: Button = findViewById(R.id.button10)
        val buttonSquare: Button = findViewById(R.id.button11)

        buttonPrime.setOnClickListener {
            performOperation("Prime")
        }

        buttonEven.setOnClickListener {
            performOperation("Even")
        }

        buttonFactorial.setOnClickListener {
            performOperation("Factorial")
        }

        buttonSquare.setOnClickListener {
            performOperation("Square")
        }

        val buttonMain: Button = findViewById(R.id.button_main)
        buttonMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performOperation(operation: String) {
        val numberString = findViewById<TextView>(R.id.editTextText).text.toString()
        if (numberString.isNotEmpty()) {
            val number = numberString.toInt()
            val result = when (operation) {
                "Prime" -> if (isPrime(number)) "Prime" else "Not Prime"
                "Even" -> if (number % 2 == 0) "Even" else "Not Even"
                "Factorial" -> factorial(number).toString()
                "Square" -> (number * number).toString()
                else -> ""
            }
            findViewById<TextView>(R.id.textView2).text = result
        } else {
            findViewById<TextView>(R.id.textView2).text = "Please enter a number first"
        }
    }

    private fun isPrime(n: Int): Boolean {
        if (n <= 1) {
            return false
        }
        for (i in 2 until n) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }

    private fun factorial(n: Int): Int {
        return if (n == 0) {
            1
        } else {
            n * factorial(n - 1)
        }
    }
}
