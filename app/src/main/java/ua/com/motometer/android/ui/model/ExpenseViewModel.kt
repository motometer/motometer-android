package ua.com.motometer.android.ui.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ua.com.motometer.android.core.facade.api.ExpenseRepository
import ua.com.motometer.android.core.facade.api.model.ExpenseRecord

class ExpenseViewModel(val expenseRepository: ExpenseRepository) : ViewModel() {
    val expenses = MutableLiveData<List<ExpenseRecord>>()
    private val disposable = CompositeDisposable()
    fun expenses() {
        expenseRepository.expenses()
                .subscribeOn(Schedulers.io())
                .subscribe(expenses::postValue)
                .let(disposable::add)
    }
}