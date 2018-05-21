package ua.com.vbychkovskyi.carlog

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import ua.com.vbychkovskyi.carlog.activity.MyCarsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.my_cars_button)
                .setOnClickListener {
                    startActivity(Intent(this, MyCarsActivity::class.java))
                }
    }
}
