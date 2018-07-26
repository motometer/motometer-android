package ua.com.motometer.activity.listener

import android.app.Activity
import android.content.Intent
import android.view.View
import com.firebase.ui.auth.AuthUI
import ua.com.motometer.activity.MainActivity


class SignOutListener(private val activity: Activity) : View.OnClickListener {
    override fun onClick(v: View?) {
        AuthUI.getInstance()
                .signOut(activity)
                .addOnCompleteListener {
                    print("Signed out")
                }

        activity.startActivity(Intent(activity, MainActivity::class.java))
    }
}