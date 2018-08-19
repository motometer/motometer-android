package ua.com.motometer.android.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import ua.com.motometer.android.core.facade.AccountFacade
import ua.com.motometer.android.core.facade.DaggerFacadesComponent
import java.util.Arrays
import javax.inject.Inject

class SignInActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 123

    var providers = Arrays.asList(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build())

    @Inject
    lateinit var accountFacade: AccountFacade

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFacadesComponent.create().inject(this)
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == Activity.RESULT_OK) {
                AsyncTask.execute {
                    accountFacade.signIn()
                }
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                startActivity(Intent(this, LauncherActivity::class.java))
            }
        }
    }
}
