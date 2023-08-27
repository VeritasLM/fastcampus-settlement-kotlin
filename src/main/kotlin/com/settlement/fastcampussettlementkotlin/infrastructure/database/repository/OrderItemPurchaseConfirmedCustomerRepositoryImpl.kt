package com.settlement.fastcampussettlementkotlin.infrastructure.database.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.settlement.fastcampussettlementkotlin.domain.criteria.SearchForPurchaseConfirmedCriteria
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem

class OrderItemPurchaseConfirmedCustomerRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): OrderItemPurchaseConfirmedCustomerRepository {

    override fun getOrderItemForPurchaseConfirmedList(criteria: SearchForPurchaseConfirmedCriteria): List<OrderItem> {
        TODO("Not yet implemented")
    }

    override fun getOrderItemForPurchaseConfirmedCount(criteria: SearchForPurchaseConfirmedCriteria): Int {
        TODO("Not yet implemented")
    }
}
