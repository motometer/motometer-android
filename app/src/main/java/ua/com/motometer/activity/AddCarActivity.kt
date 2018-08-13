package ua.com.motometer.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import ua.com.motometer.R

class AddCarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)
        findViewById<Button>(R.id.create_car).setOnClickListener({
            val carName = findViewById<TextView>(R.id.car_name).text
            val carMadeYear = findViewById<TextView>(R.id.car_made_year_input).text
            val carRunDistance = findViewById<TextView>(R.id.car_run_distance).text

            startActivity(Intent(this, LauncherActivity::class.java))
        })
    }
}
