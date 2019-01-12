package ua.com.motometer.android.ui.state

import android.util.Log
import ua.com.motometer.android.ui.state.api.Action
import ua.com.motometer.android.ui.state.api.State


internal fun State.logAction(action: Action): Action {
    Log.d("ActionLog:${this.javaClass.simpleName}", "Action performed: $action")
    return action
}
