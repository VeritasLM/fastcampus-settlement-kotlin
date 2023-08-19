package com.settlement.fastcampussettlementkotlin.infrastructure.database.repository

import com.settlement.fastcampussettlementkotlin.domain.criteria.SearchForPurchaseConfirmedCriteria
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem

interface OrderItemPurchaseConfirmedCustomerRepository {
    fun getOrderItemForPurchaseConfirmedList(criteria: SearchForPurchaseConfirmedCriteria): List<OrderItem>
    fun getOrderItemForPurchaseConfirmedCount(criteria: SearchForPurchaseConfirmedCriteria): Int
}
