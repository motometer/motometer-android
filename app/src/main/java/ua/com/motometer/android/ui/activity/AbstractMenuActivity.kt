package ua.com.motometer.android.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.Menu
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.nav_header_home.*
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.api.UserFacade
import ua.com.motometer.android.ui.common.ReadWriteTask
import ua.com.motometer.android.ui.state.MenuHandler
import ua.com.motometer.android.ui.state.SignOut
import ua.com.motometer.android.ui.state.State
import javax.inject.Inject

abstract class AbstractMenuActivity(initialState: State) : AbstractStatefulActivity(initialState), MenuHandler {

    @Inject
    lateinit var userFacade: UserFacade

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFacadeComponent.create().inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)

        ReadWriteTask(userFacade::currentUser) { account ->
            nav_header_title.text = account.displayName()
            nav_header_email.text = account.email()
        }.execute()

        return true
    }

    final override fun handleSignOut(state: SignOut) {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener {
                    drawerLayout().closeDrawer(GravityCompat.START)
                    this.startActivity(Intent(this, LauncherActivity::class.java))
                }
    }

    abstract fun drawerLayout(): DrawerLayout
}