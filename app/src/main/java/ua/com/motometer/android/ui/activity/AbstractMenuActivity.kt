package ua.com.motometer.android.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import kotlinx.android.synthetic.main.nav_header_home.*
import ua.com.motometer.android.R
import ua.com.motometer.android.core.facade.AccountFacade
import ua.com.motometer.android.core.facade.DaggerFacadesComponent
import ua.com.motometer.android.ui.common.ReadWriteTask
import javax.inject.Inject

abstract class AbstractMenuActivity : AppCompatActivity() {

    @Inject
    lateinit var accountFacade: AccountFacade

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFacadesComponent.create().inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)

        ReadWriteTask(accountFacade::currentUser) { account ->
            nav_header_title.text = account.displayName()
            nav_header_email.text = account.email()
        }.execute()

        return true
    }
}