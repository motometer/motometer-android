package ua.com.motometer.android.ui.menu

import android.content.Context
import android.content.Intent
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import com.firebase.ui.auth.AuthUI
import ua.com.motometer.android.ui.activity.LauncherActivity

internal class SignOutAction(private val drawerLayout: DrawerLayout, private val context: Context) : Function0<Boolean> {

    override fun invoke(): Boolean {
        AuthUI.getInstance()
                .signOut(context)
                .addOnCompleteListener {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    context.startActivity(Intent(context, LauncherActivity::class.java))
                }
        return true
    }
}