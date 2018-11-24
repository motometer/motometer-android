package ua.com.motometer.android.ui.state.home

import ua.com.motometer.android.R

enum class RecordType(val viewId: Int, val expenseRecordFactory: ExpenseRecordFactory) {
    FUEL(R.layout.fragment_new_record_fuel, FuelRecordFactory()),
    SERVICE(R.layout.fragment_new_record_service, ServiceRecordFactory());
}