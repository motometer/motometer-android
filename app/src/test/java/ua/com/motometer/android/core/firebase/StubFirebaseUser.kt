package ua.com.motometer.android.core.firebase

import android.net.Uri
import android.os.Parcel
import com.google.android.gms.internal.firebase_auth.zzcz
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.FirebaseUserMetadata
import com.google.firebase.auth.UserInfo

class StubFirebaseUser(
        private val email: String?,
        private val name: String?,
        private val imageUrl: String?
) : FirebaseUser() {

    override fun getEmail(): String? = email

    override fun getPhotoUrl(): Uri? = Uri.parse(imageUrl)

    override fun getDisplayName(): String? = name

    override fun zza(p0: MutableList<out UserInfo>): FirebaseUser = TODO("not implemented")

    override fun getProviderData(): MutableList<out UserInfo> = TODO("not implemented")

    override fun writeToParcel(dest: Parcel?, flags: Int): Unit = TODO("not implemented")

    override fun getMetadata(): FirebaseUserMetadata? = TODO("not implemented")

    override fun isAnonymous(): Boolean = TODO("not implemented")

    override fun getPhoneNumber(): String? = TODO("not implemented")

    override fun getUid(): String = TODO("not implemented")

    override fun isEmailVerified(): Boolean = TODO("not implemented")

    override fun getProviders(): MutableList<String> = TODO("not implemented")

    override fun getProviderId(): String = TODO("not implemented")

    override fun zza(p0: zzcz): Unit = TODO("not implemented")

    override fun zzch(): String = TODO("not implemented")

    override fun zzcf(): String? = TODO("not implemented")

    override fun zzcc(): FirebaseApp = TODO("not implemented")

    override fun zzci(): String = TODO("not implemented")

    override fun zzcg(): zzcz = TODO("not implemented")

    override fun zzce(): FirebaseUser = TODO("not implemented")
}