package com.settlement.fastcampussettlementkotlin.infrastructure.database

import com.settlement.fastcampussettlementkotlin.domain.PurchaseConfirmedReader
import com.settlement.fastcampussettlementkotlin.domain.criteria.SearchForPurchaseConfirmedCriteria
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.OrderItemRepository
import org.springframework.stereotype.Service

@Service
class PurchaseConfirmedJpaCreator(private val repository: OrderItemRepository) :PurchaseConfirmedReader{
    override fun getPurchaseConfirmedItemList(criteria: SearchForPurchaseConfirmedCriteria): List<OrderItem> {
        return repository.getOrderItemForPurchaseConfirmedList(criteria)
    }

    override fun getPurchaseConfirmedItemCount(criteria: SearchForPurchaseConfirmedCriteria): Int {
        return repository.getOrderItemForPurchaseConfirmedCount(criteria)
    }
}
