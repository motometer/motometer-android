package ua.com.motometer.android.ui.activity

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.Menu
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.nav_header_home.*
import ua.com.motometer.android.R
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.core.facade.api.UserFacade
import ua.com.motometer.android.core.firebase.FirebaseModule
import ua.com.motometer.android.ui.common.ReadWriteTask
import ua.com.motometer.android.ui.state.SignOut
import ua.com.motometer.android.ui.state.api.MenuHandler
import ua.com.motometer.android.ui.state.api.State
import java.net.URI
import javax.inject.Inject


abstract class AbstractMenuActivity(initialState: State) : AbstractStatefulActivity(initialState), MenuHandler {

    @Inject
    lateinit var userFacade: UserFacade

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerActivityComponent.builder()
                .facadeModule(FacadeModule())
                .roomModule(RoomModule(application))
                .firebaseModule(FirebaseModule())
                .build()
                .inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)

        ReadWriteTask(userFacade::currentUser) { account ->
            nav_header_title.text = account.displayName()
            nav_header_email.text = account.email()
            ReadWriteTask({
                return@ReadWriteTask BitmapFactory.decodeStream(URI(account.avatarUrl()).toURL().openConnection().getInputStream())
            }, {
                nav_header_avatar.setImageBitmap(it)
            }).execute()

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