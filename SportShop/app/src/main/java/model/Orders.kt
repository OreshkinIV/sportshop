package model

import java.util.Date

data class Orders(
    val orderId: Int,
    val user: User,
    val amount: Double,
    val date: Date
)
