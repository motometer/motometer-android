package ua.com.motometer.android.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.AccountFacade
import ua.com.motometer.android.core.facade.DaggerFacadesComponent
import javax.inject.Inject


class LauncherActivity : AppCompatActivity() {

    @Inject
    lateinit var accountFacade: AccountFacade

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        DaggerFacadesComponent.create().inject(this)

        if (accountFacade.isAuthenticated()) {
            Log.d(javaClass.simpleName, "User is authenticated")
            startActivity(Intent(this, HomeActivity::class.java))
        } else {
            Log.d(javaClass.simpleName, "Launching SignInActivity")
            startActivity(Intent(this, SignInActivity::class.java))
        }
        finish()
    }
}
