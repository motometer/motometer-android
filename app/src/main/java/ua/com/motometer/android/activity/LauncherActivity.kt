package ua.com.motometer.android.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import ua.com.motometer.android.R


class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val account = FirebaseAuth.getInstance().currentUser

        if (account == null) {
            startActivity(Intent(this, SignInActivity::class.java))
        } else{
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}
