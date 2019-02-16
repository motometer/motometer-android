package ua.com.motometer.android.core.dao

import android.support.test.runner.AndroidJUnit4
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class RecordDaoTest : AbstractDaoTest() {
    @Test
    fun addFuelRecord() {
        val recordDao = applicationDatabase.recordDao()

        val record = Record(
                UUID.randomUUID().toString(),
                5000,
                447.55,
                "TO 0",
                "2019"
        )

        recordDao.insert(record)

        assertThat(recordDao.findAll()).hasSize(1)
    }
}