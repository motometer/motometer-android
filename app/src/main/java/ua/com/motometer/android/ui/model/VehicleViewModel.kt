package ua.com.motometer.android.ui.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ua.com.motometer.android.core.facade.api.VehicleRepository
import ua.com.motometer.android.core.facade.api.model.Vehicle

class VehicleViewModel(private val vehicleRepository: VehicleRepository) : ViewModel() {

    val vehicle = MutableLiveData<Vehicle>()
    private val disposable = CompositeDisposable()

    fun vehicle(id: Long) {
        vehicleRepository.vehicle(id)
                .subscribeOn(Schedulers.io())
                .subscribe(vehicle::postValue)
                .let(disposable::add)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}