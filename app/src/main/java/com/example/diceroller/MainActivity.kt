package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


/**This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
//      The toast below gives a short notification of your action clicking the button
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            rollDice()
        }
    }

    //Roll the dice and update the screen with result
    private fun rollDice() {
        //create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // create second new Dice object with 6 sides and roll it
        val diceTwo = Dice(6)
        val diceTwoRoll = diceTwo.roll()

        //update the screen with dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
        //update the second dice screen with dice roll
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceTwoRoll.toString()
    }
}

// function for random selection of dice side from 1..numSide
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}

