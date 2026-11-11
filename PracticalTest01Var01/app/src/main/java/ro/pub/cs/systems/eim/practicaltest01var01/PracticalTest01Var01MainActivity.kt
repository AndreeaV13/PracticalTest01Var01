package ro.pub.cs.systems.eim.practicaltest01var01

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.util.Log
class PracticalTest01Var01MainActivity : AppCompatActivity() {
    private var leftCount = 0
    private var rightCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var01_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        val leftText = findViewById<EditText>(R.id.left_text)
        val rightText = findViewById<EditText>(R.id.right_text)
        val leftMinusButton = findViewById<Button>(R.id.left_minus_button)
        val leftPlusButton = findViewById<Button>(R.id.left_plus_button)
        val rightMinusButton = findViewById<Button>(R.id.right_minus_button)
        val rightPlusButton = findViewById<Button>(R.id.right_plus_button)

        if (savedInstanceState != null) {
            leftCount = savedInstanceState.getInt("leftCount")
            rightCount = savedInstanceState.getInt("rightCount")
            leftText.setText(leftCount.toString())
            rightText.setText(rightCount.toString())
            Log.d("PracticalTest01Var01", "onCreate: $leftCount $rightCount")

        }

        leftMinusButton.setOnClickListener {
            leftCount--
            leftText.setText(leftCount.toString())
        }
        leftPlusButton.setOnClickListener {
            leftCount++
            leftText.setText(leftCount.toString())
        }
        rightMinusButton.setOnClickListener {
            rightCount--
            rightText.setText(rightCount.toString())
        }
        rightPlusButton.setOnClickListener {
            rightCount++
            rightText.setText(rightCount.toString())
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("leftCount", leftCount)
        outState.putInt("rightCount", rightCount)
        Log.d("PracticalTest01Var01", "onSaveInstanceState: $leftCount $rightCount")
    }

}