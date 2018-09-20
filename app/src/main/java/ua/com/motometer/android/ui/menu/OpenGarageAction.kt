package ua.com.motometer.android.ui.menu

import android.content.Context
import android.content.Intent
import android.support.v4.widget.DrawerLayout
import ua.com.motometer.android.ui.activity.GarageActivity

class OpenGarageAction(drawerLayout: DrawerLayout, val context: Context) : BaseMenuAction(drawerLayout) {
    override fun invoke(): Boolean {
        val superResult = super.invoke()

        if (context !is GarageActivity) {
            context.startActivity(Intent(context, GarageActivity::class.java))
        }

        return superResult
    }
}