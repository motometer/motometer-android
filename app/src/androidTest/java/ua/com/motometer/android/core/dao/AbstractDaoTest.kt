package ua.com.motometer.android.core.dao

import android.arch.persistence.room.Room
import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import ua.com.motometer.android.core.db.ApplicationDatabase

@RunWith(AndroidJUnit4::class)
open class AbstractDaoTest {

    lateinit var applicationDatabase: ApplicationDatabase

    @Before
    fun setUp() {
        val context: Context = InstrumentationRegistry.getTargetContext()
        applicationDatabase = Room.inMemoryDatabaseBuilder(context, ApplicationDatabase::class.java).build()
    }

    @After
    fun tearDown() = applicationDatabase.close()
}