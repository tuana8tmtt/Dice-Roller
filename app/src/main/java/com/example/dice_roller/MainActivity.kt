package com.example.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

        // Do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        // Find the ImageView in the layout
        val diceImage1 = findViewById<ImageView>(R.id.dice1)
        val diceImage2 = findViewById<ImageView>(R.id.dice2)

        val resultText = findViewById<TextView>(R.id.textView)

        // Update the ImageView and textView with the diceRoll and image
        diceImage1.setImageResource(dice2Image(diceRoll1))
        diceImage2.setImageResource(dice2Image(diceRoll2))

        resultText.text = String.format("Dice 1: %d\nDice 2: %d", diceRoll1, diceRoll2)

        // Update the content description
        diceImage1.contentDescription = diceRoll1.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

// Determine which resource ID (image name) to use
fun dice2Image(diceRoll: Int): Int {
    return when (diceRoll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}