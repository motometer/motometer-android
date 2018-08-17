package ua.com.motometer.android.model

import java.time.LocalDateTime


interface TrackItem {
    val date: LocalDateTime
    val name: String
}