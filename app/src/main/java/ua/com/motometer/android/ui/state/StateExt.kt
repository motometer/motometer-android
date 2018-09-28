package ua.com.motometer.android.ui.state

import android.util.Log


internal fun State.logAction(action: Action): Action {
    Log.d("ActionLog:${this.javaClass.simpleName}", "Action performed: $action")
    return action
}
