package ua.com.motometer.android.ui.model

import androidx.lifecycle.ViewModel
import io.reactivex.Flowable
import ua.com.motometer.android.core.facade.api.UserRepository
import ua.com.motometer.android.core.facade.api.model.User

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun currentUser(): Flowable<User> = userRepository.currentUser()
}