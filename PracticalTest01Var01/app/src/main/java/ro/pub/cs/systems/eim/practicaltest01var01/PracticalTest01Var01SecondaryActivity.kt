package ro.pub.cs.systems.eim.practicaltest01var01

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText

class PracticalTest01Var01SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var01_secondary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val totalText = findViewById<EditText>(R.id.sum_text)
        val okButton = findViewById<Button>(R.id.accept_button)
        val cancelButton = findViewById<Button>(R.id.reject_button)

        val left = intent.getIntExtra("leftCount", 0)     // primul bilet
        val right = intent.getIntExtra("rightCount", 0)   // al doilea bilet
        totalText.setText((left + right).toString())      // le aduni și afișezi

 
        okButton.setOnClickListener {
            setResult(RESULT_OK)                 // răspunsul: "OK"
            finish()                             // închide ecranul 2 -> revii la ecranul 1
        }
        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)           // răspunsul: "Cancel"
            finish()

        }
    }
}