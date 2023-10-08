package com.settlement.fastcampussettlementkotlin.core.job.total

import com.settlement.fastcampussettlementkotlin.domain.entity.settlement.SettlementTotal
import com.settlement.fastcampussettlementkotlin.domain.projection.SummingSettlementResponse
import org.springframework.batch.item.ItemProcessor
import java.time.LocalDate

class TotalSettlementItemProcessor: ItemProcessor<SummingSettlementResponse, SettlementTotal> {

    override fun process(item: SummingSettlementResponse): SettlementTotal {
        return SettlementTotal(
            settlementDate = LocalDate.now(),
            sellerNo = item.sellerNo,
            sellerName = item.sellerName,
            sellerBusinessNumber = item.sellerBusinessNumber,
            sellType = item.sellType,
            taxType = item.taxType,
            pgSalesAmount = item.sumPgSalesAmount,
            couponDiscountAmount = item.sumCouponDiscountAmount,
            mileageUsageAmount = item.sumMileageUsageAmount,
            shippingFeeAmount = item.sumShippingFeeAmount,
            claimShippingFeeAmount = item.sumClaimShippingFeeAmount,
            commissionAmount = item.sumCommissionAmount,
            taxAmount = item.sumTaxAmount
        )
    }
}







