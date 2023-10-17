package com.settlement.fastcampussettlementkotlin.domain.collection

import com.settlement.fastcampussettlementkotlin.domain.command.PgSalesAmountMaterial
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItemSnapshot
import java.math.BigDecimal

class PgSalesAmountCalculator(
    //private val orderItemSnapshot: OrderItemSnapshot,
    private val pgSalesAmountMaterial: PgSalesAmountMaterial,
) {

    /**
     * PG - 결제 수단 , 현금 금액
     */
    fun getPgSaleAmount(): BigDecimal {
        val price = pgSalesAmountMaterial.sellPrice ?: BigDecimal.ZERO

        return price.subtract(pgSalesAmountMaterial.promotionAmount)
            .subtract(pgSalesAmountMaterial.mileageUsageAmount)
    }
}




