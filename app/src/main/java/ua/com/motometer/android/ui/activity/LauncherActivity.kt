package ua.com.motometer.android.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.api.UserRepository
import javax.inject.Inject


class LauncherActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        injector().inject(this)

        if (userRepository.isAuthenticated()) {
            Log.d(javaClass.simpleName, "User is authenticated")
            startActivity(Intent(this, HomeActivity::class.java))
        } else {
            Log.d(javaClass.simpleName, "Launching SignInActivity")
            startActivity(Intent(this, SignInActivity::class.java))
        }
        finish()
    }
}
