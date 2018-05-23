package ua.com.vbychkovskyi.carlog.activity.listener

import android.app.Activity
import android.content.Intent
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import ua.com.vbychkovskyi.carlog.activity.MainActivity

class SignOutListener(private val activity: Activity) : View.OnClickListener {
    override fun onClick(v: View?) {
        val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        GoogleSignIn.getClient(activity, signInOptions)
                .signOut()

        activity.startActivity(Intent(activity, MainActivity::class.java))
    }
}