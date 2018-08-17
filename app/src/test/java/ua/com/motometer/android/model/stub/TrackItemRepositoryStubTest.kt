package ua.com.motometer.android.model.stub

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class TrackItemRepositoryStubTest {

    @Test
    fun items() {
        val stub = TrackItemRepositoryStub()

        val result = stub.items()

        assertThat(result.size).isEqualTo(20)
    }
}