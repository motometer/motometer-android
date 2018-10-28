package ua.com.motometer.android.core.firebase

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class FirebaseUserAdapterTest {

    @ParameterizedTest
    @MethodSource("args")
    fun nullUser(email: String?, name: String?, imageUrl: String?) {
        val user = FirebaseUserAdapter(StubFirebaseUser(email, name, imageUrl))

        assertThat(user.displayName()).isEqualTo(name ?: "")
        assertThat(user.email()).isEqualTo(email ?: "")
    }

    companion object FirebaseUserAdapterTest {
        @JvmStatic
        fun args(): List<Any> {
            return listOf(
                    Arguments { arrayOf("name@email.com", "name", "http://example.com") },
                    Arguments { arrayOf("name@email.com", null, "http://example.com") },
                    Arguments { arrayOf(null, null, "http://example.com") }
            )
        }
    }
}
