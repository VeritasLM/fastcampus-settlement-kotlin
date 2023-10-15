package com.settlement.fastcampussettlementkotlin.domain.collection

import com.settlement.fastcampussettlementkotlin.domain.command.PgSalesAmountMaterial
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import com.settlement.fastcampussettlementkotlin.domain.entity.settlement.SettlementDaily
import java.time.LocalDate

class PositiveDailySettlementCollection(
    private val item: OrderItem
) {

    fun getSettlementDaily(): SettlementDaily {
        val orderItemSnapshot = item.orderItemSnapshot
        val count = item.orderCount ?: 1
        val countToDecimal = count.toBigDecimal()
        val seller = orderItemSnapshot.seller

        //세금계산
        val taxCalculator = TaxCalculator(orderItemSnapshot)
        val taxAmount = taxCalculator.getTaxAmount().multiply(countToDecimal)

        //+ 정산금액에 필요한 데이터 만들기
        val pgSalesAmountMaterial = PgSalesAmountMaterial(
            orderItemSnapshot.sellPrice,
            orderItemSnapshot.promotionAmount,
            orderItemSnapshot.mileageUsageAmount
        )
        val pgCalculator = PgSalesAmountCalculator(orderItemSnapshot)
        val pgSalesAmount = pgCalculator.getPgSaleAmount().multiply(countToDecimal)

        val commissionAmountCalculator = CommissionAmountCalculator(orderItemSnapshot)
        val commissionAmount = commissionAmountCalculator.getCommissionAmount().multiply(countToDecimal)

        return SettlementDaily(
            settlementDate = LocalDate.now(),
            orderNo = item.orderNo,
            orderCount = count,
            orderItemNo = item.orderItemSnapshotNo,
            sellerNo = orderItemSnapshot.sellerNo,
            sellerBusinessNumber = seller.businessNo,
            sellerName = seller.sellerName,
            sellType = seller.sellType,
            taxType = orderItemSnapshot.taxType,
            taxAmount = taxAmount,
            commissionAmount = commissionAmount,
            pgSalesAmount = pgSalesAmount,
            couponDiscountAmount = orderItemSnapshot.promotionAmount,
            mileageUsageAmount = orderItemSnapshot.mileageUsageAmount,
            shippingFeeAmount = orderItemSnapshot.defaultDeliveryAmount,
        )
    }
}