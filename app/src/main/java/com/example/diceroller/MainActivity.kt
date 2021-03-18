package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_dice_button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Create second  Dice object with 6 sides and roll it
        val secondDice = Dice(6)
        val secondDiceRoll = secondDice.rollDice2()

        // Find the ImageView in the layout
        val resultImageView: ImageView = findViewById(R.id.imageView)
        // Find the secongImageView in the layout
        val secondDiceImageView: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        // Determine which drawable resource ID to use based on the second dice roll
        val secondDrawableResource = when (secondDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }

        // Update the ImageView with the correct drawable resource ID
        resultImageView.setImageResource(drawableResource)
        // Update the secondImageView with the correct drawable resource ID
        secondDiceImageView.setImageResource(secondDrawableResource)


        // Update the content description
        resultImageView.contentDescription = diceRoll.toString()
        // Update the second content description
        secondDiceImageView.contentDescription = secondDiceRoll.toString()
    }

    //Show toast notification for failed
    private fun showErrorMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    //Show toast notification for success
    private fun showSuccessToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }

    fun rollDice2(): Int {
        return (1..numSides).random()
    }
}