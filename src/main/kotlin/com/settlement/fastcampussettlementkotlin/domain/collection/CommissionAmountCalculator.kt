package com.settlement.fastcampussettlementkotlin.domain.collection

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItemSnapshot
import java.math.BigDecimal

class CommissionAmountCalculator(
    private val itemSnapshot: OrderItemSnapshot
) {

    fun getCommissionAmount(): BigDecimal {
        val seller = itemSnapshot.seller
        val price = itemSnapshot.sellPrice ?: BigDecimal.ZERO

        //마진 금액 (판매가 - 공급가)
        val marginAmount = price.subtract(itemSnapshot.supplyPrice)

        //수수료 비율 (INT -> % )
        val commission = seller.commission ?: 0

        return getCalculate(marginAmount, commission)
    }

    private fun getCalculate(marginAmount: BigDecimal, commission: Int): BigDecimal {
        if (commission == 0) {
            return BigDecimal.ZERO
        }

        //수수료 비율 (INT -> % )
        val rate = commission.div(100).toBigDecimal()


        return marginAmount.multiply(rate)
    }

}