package ua.com.motometer.android.ui.activity

import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import android.util.Log
import android.view.Menu
import com.firebase.ui.auth.AuthUI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.nav_header_home.*
import ua.com.motometer.android.ui.common.ReadWriteTask
import ua.com.motometer.android.ui.model.UserViewModel
import ua.com.motometer.android.ui.model.ViewModelFactory
import ua.com.motometer.android.ui.state.SignOut
import ua.com.motometer.android.ui.state.api.Actions
import ua.com.motometer.android.ui.state.api.MenuHandler
import ua.com.motometer.android.ui.state.api.State
import javax.inject.Inject
import ua.com.motometer.android.ui.state.MenuOpened as MenuState


abstract class AbstractMenuActivity(initialState: State) : AbstractStatefulActivity(initialState), MenuHandler {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: UserViewModel

    private val disposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector().inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val result = super.onCreateOptionsMenu(menu)
        updateUser()
        return result
    }

    private fun updateUser() {
        disposable.add(viewModel.currentUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    nav_header_title.text = it.displayName()
                    nav_header_email.text = it.email()
                    ReadWriteTask(AvatarBitmapFactory(it)::asBitmap) { user ->
                        nav_header_avatar.setImageBitmap(user)
                    }.execute()
                },
                        { error -> Log.e("AA", "Unable to get username", error) }))
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
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

    fun menuClosed() {
        drawerLayout().closeDrawer(GravityCompat.START)
        onAction(Actions.Common.Back)
    }
}