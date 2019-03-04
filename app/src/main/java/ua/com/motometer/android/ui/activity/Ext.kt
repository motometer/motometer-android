package ua.com.motometer.android.ui.activity

import androidx.appcompat.app.AppCompatActivity
import ua.com.motometer.android.core.dao.RoomModule
import ua.com.motometer.android.core.facade.api.FacadeModule
import ua.com.motometer.android.core.firebase.FirebaseModule

fun AppCompatActivity.injector(): ActivityComponent {
    return DaggerActivityComponent.builder()
            .facadeModule(FacadeModule())
            .roomModule(RoomModule(application))
            .firebaseModule(FirebaseModule())
            .build()
}