package com.settlement.fastcampussettlementkotlin.domain

interface OrderPurchaseConfirmedExecutor {
    fun confirmed(orderNo: Long)
}
