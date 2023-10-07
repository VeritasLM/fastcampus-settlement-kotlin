package com.settlement.fastcampussettlementkotlin.domain.collection

import com.settlement.fastcampussettlementkotlin.domain.TaxTypeItem
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItemSnapshot
import com.settlement.fastcampussettlementkotlin.domain.enums.TaxType
import java.math.BigDecimal

class TaxCalculator(
    private val orderItemSnapshot: OrderItemSnapshot,
) {

    private val TAX_RATE = 0.03

    private fun getTaxTypeItem(): TaxTypeItem {
        return when(orderItemSnapshot.taxType) {
            TaxType.TAX -> TaxTypeItem.TaxItem(orderItemSnapshot.sellPrice)
            TaxType.FREE -> TaxTypeItem.TaxFreeItem(orderItemSnapshot.sellPrice)
            TaxType.ZERO -> TaxTypeItem.ZeroTaxItem(orderItemSnapshot.sellPrice)
            null -> TaxTypeItem.TaxItem(orderItemSnapshot.sellPrice)
        }
    }

    fun getTaxAmount(): BigDecimal {
        val taxTypeItem = getTaxTypeItem()

        return when(taxTypeItem) {
            is TaxTypeItem.TaxItem -> getCalculateTaxForTaxItem(taxTypeItem)
            is TaxTypeItem.ZeroTaxItem -> taxTypeItem.price ?: BigDecimal.ZERO
            is TaxTypeItem.TaxFreeItem -> taxTypeItem.price ?: BigDecimal.ZERO
            else -> BigDecimal.ZERO
        }
    }

    private fun getCalculateTaxForTaxItem(taxItem: TaxTypeItem.TaxItem): BigDecimal {
        val price = taxItem.price ?: BigDecimal.ZERO
        val rate = BigDecimal.valueOf(TAX_RATE) // 0.03

        //비즈니스 로직이 들어가는 예
        if (orderItemSnapshot.itemCategory == 1) {
            return price.multiply(BigDecimal.valueOf(0.20))
        }

        return price.multiply(rate)
    }

}