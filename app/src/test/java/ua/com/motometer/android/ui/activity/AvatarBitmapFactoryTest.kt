package ua.com.motometer.android.ui.activity

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ua.com.motometer.android.core.facade.api.model.ImmutableUser

internal class AvatarBitmapFactoryTest {
    @Test
    internal fun shouldNotFail() {
        val factory = AvatarBitmapFactory(ImmutableUser.of("name", "user", "http://error.motometer.com.ua"))

        val bitmap = factory.asBitmap()

        assertThat(bitmap).isNull()
    }
}