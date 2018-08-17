package ua.com.motometer.android.model.stub

import ua.com.motometer.android.model.TrackItem
import ua.com.motometer.android.model.TrackItemRepository
import java.time.LocalDateTime
import java.util.stream.Stream

class TrackItemRepositoryStub : TrackItemRepository {
    override fun items(): List<TrackItem> {
        return IntRange(0, 19)
                .map { Item(LocalDateTime.now(), "Item number $it") }
    }
}

data class Item(override val date: LocalDateTime, override val name: String) : TrackItem
