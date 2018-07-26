package ua.com.motometer.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import ua.com.motometer.R
import ua.com.motometer.activity.listener.SignOutListener


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.sign_out).setOnClickListener(SignOutListener(this))

        val account = FirebaseAuth.getInstance().currentUser

        if (account == null) {
            startActivity(Intent(this, SignInActivity::class.java))
        }

        findViewById<TextView>(R.id.welcome_header).text = account?.displayName ?: "Unknown"
    }
}
