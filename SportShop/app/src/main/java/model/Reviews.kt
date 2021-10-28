package model

import java.util.Date

data class Reviews(
    val user: User,
    val text: String,
    val date: Date
)
