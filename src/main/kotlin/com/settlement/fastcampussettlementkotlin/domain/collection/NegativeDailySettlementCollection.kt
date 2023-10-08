package com.settlement.fastcampussettlementkotlin.domain.collection

import com.settlement.fastcampussettlementkotlin.domain.entity.claim.ClaimItem
import com.settlement.fastcampussettlementkotlin.domain.entity.settlement.SettlementDaily
import java.math.BigDecimal
import java.time.LocalDate

class NegativeDailySettlementCollection(
    private val item: ClaimItem
) {

    fun getSettlementDaily(): SettlementDaily {
        val orderItem = item.orderItem
        val orderItemSnapshot = orderItem.orderItemSnapshot

        val count = item.claimCount ?: -1
        val countToDecimal = count.toBigDecimal()
        val seller = orderItemSnapshot.seller

        //세금 계산
        val taxCalculator = TaxCalculator(orderItemSnapshot)
        val taxAmount = taxCalculator.getTaxAmount().multiply(countToDecimal)

        //- 정산금액에 필요한 데이터 만들기
        val pgCalculator = PgSalesAmountCalculator(orderItemSnapshot)
        val pgSalesAmount = pgCalculator.getPgSaleAmount().multiply(countToDecimal)

        val commissionAmountCalculator = CommissionAmountCalculator(orderItemSnapshot)
        val commissionAmount = commissionAmountCalculator.getCommissionAmount().multiply(countToDecimal)

        val claimShippedAmountCalculator = ClaimShippedAmountCalculator(item)
        val claimShippingFeeAmount = claimShippedAmountCalculator.getClaimShippedAmount() // ZERO

        return SettlementDaily(
            settlementDate = LocalDate.now(),
            orderNo = orderItem.orderNo,
            orderCount = count,
            orderItemNo = orderItem.orderItemSnapshotNo,
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
            claimReceiptNo = item.claimReceiptNo,
            claimShippingFeeAmount = claimShippingFeeAmount

        )
    }
}