package ua.com.motometer.android.ui.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ua.com.motometer.android.core.facade.api.UserRepository
import ua.com.motometer.android.core.facade.api.VehicleRepository

class ViewModelFactory(private val userRepository: UserRepository,
                       private val vehicleRepository: VehicleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(userRepository) as T
        }
        if (modelClass.isAssignableFrom(VehicleViewModel::class.java)) {
            return VehicleViewModel(vehicleRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}