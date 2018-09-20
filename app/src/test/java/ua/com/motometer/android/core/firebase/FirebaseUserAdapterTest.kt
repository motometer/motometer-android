package ua.com.motometer.android.core.firebase

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class FirebaseUserAdapterTest {
    @Test
    fun nullUser() {
        val user = FirebaseUserAdapter(null)

        assertThatThrownBy {
            user.displayName()
        }.isInstanceOf(KotlinNullPointerException::class.java)

        assertThatThrownBy {
            user.email()
        }.isInstanceOf(KotlinNullPointerException::class.java)
    }
}
