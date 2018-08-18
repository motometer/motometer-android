package ua.com.motometer.android.facade.impl

import ua.com.motometer.android.facade.AccountFacade
import ua.com.motometer.android.facade.model.Account
import javax.inject.Inject

class DefaultAccountFacade @Inject constructor() : AccountFacade {
    override fun signIn() {
        TODO("not implemented")
    }

    override fun currentUser(): Account {
        TODO("not implemented")
    }
}