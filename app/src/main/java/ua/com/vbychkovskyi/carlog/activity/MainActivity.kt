package ua.com.vbychkovskyi.carlog.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import ua.com.vbychkovskyi.carlog.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.sign_out)
                .setOnClickListener {
                    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                            .requestEmail()
                            .build()

                    val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

                    mGoogleSignInClient.signOut()
                }

        val account = GoogleSignIn.getLastSignedInAccount(this)

        if (account == null) {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}
