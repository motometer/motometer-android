package ua.com.motometer.android.model

interface TrackItemRepository {
    fun items(): List<TrackItem>
}