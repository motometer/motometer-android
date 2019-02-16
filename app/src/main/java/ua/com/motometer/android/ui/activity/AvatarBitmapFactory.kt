package ua.com.motometer.android.ui.activity

import android.graphics.Bitmap
import android.util.Log
import ua.com.motometer.android.core.facade.api.model.User
import java.net.URI
import android.graphics.BitmapFactory as factory

class AvatarBitmapFactory(private val user: User) : BitmapFactory {
    override fun asBitmap(): Bitmap? {
        return try {
            factory.decodeStream(URI(user.avatarUrl()).toURL().openConnection().getInputStream())
        } catch (e: Exception) {
            Log.w(javaClass.simpleName, "Could not load image")
            null
        }
    }
}