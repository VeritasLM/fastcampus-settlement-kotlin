package com.settlement.fastcampussettlementkotlin.domain

import com.settlement.fastcampussettlementkotlin.domain.criteria.SearchForPurchaseConfirmedCriteria
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem

/**
 * List, Count조회를 위한 Reader Interface
 */
interface PurchaseConfirmedReader {
    fun getPurchaseConfirmedItemList(criteria: SearchForPurchaseConfirmedCriteria): List<OrderItem>
    fun getPurchaseConfirmedItemCount(criteria: SearchForPurchaseConfirmedCriteria): Int
}
