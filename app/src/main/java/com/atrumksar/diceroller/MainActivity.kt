package com.atrumksar.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.concurrent.thread
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var flag: Boolean = true
    private lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        if (flag) {
            flag = false
            val myThread = thread(start = true, isDaemon = true) {
                while (!flag) {
                    val diceRandom = when (Random.nextInt(7)) {
                        1 -> R.drawable.dice_1
                        2 -> R.drawable.dice_2
                        3 -> R.drawable.dice_3
                        4 -> R.drawable.dice_4
                        5 -> R.drawable.dice_5
                        else -> R.drawable.dice_6
                    }
                    val diceImage: ImageView = findViewById(R.id.dice_image)
                    diceImage.setImageResource(diceRandom)
                    Thread.sleep(50);
                }
            }
        } else {
            flag = true
        }
    }
}