package ua.com.motometer.android.core.dao

import androidx.room.Room
import android.content.Context
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import ua.com.motometer.android.core.db.ApplicationDatabase

@RunWith(AndroidJUnit4::class)
abstract class AbstractDaoTest {

    lateinit var applicationDatabase: ApplicationDatabase

    @Before
    fun setUp() {
        val context: Context = InstrumentationRegistry.getTargetContext()
        applicationDatabase = Room.inMemoryDatabaseBuilder(context, ApplicationDatabase::class.java).build()
    }

    @After
    fun tearDown() = applicationDatabase.close()
}