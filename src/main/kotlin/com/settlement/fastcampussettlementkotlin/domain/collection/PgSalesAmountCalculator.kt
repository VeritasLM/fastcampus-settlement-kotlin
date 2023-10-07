package com.settlement.fastcampussettlementkotlin.domain.collection

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItemSnapshot
import java.math.BigDecimal

class PgSalesAmountCalculator(
    private val orderItemSnapshot: OrderItemSnapshot,
) {

    /**
     * PG - 결제 수단 , 현금 금액
     */
    fun getPgSaleAmount(): BigDecimal {
        val price = orderItemSnapshot.sellPrice ?: BigDecimal.ZERO

        return price.subtract(orderItemSnapshot.promotionAmount)
            .subtract(orderItemSnapshot.mileageUsageAmount)
    }
}




