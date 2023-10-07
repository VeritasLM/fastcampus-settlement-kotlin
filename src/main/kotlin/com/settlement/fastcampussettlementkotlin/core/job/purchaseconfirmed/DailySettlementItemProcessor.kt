package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import com.settlement.fastcampussettlementkotlin.domain.entity.settlement.SettlementDaily
import org.springframework.batch.item.ItemProcessor
import java.math.BigDecimal
import java.time.LocalDate

class DailySettlementItemProcessor: ItemProcessor<OrderItem, SettlementDaily> {

    /**
     * + 정산금액을 만들기
     */
    override fun process(item: OrderItem): SettlementDaily {

        val orderItemSnapshot = item.orderItemSnapshot
        val count = item.orderCount
        val seller = orderItemSnapshot.seller
        //세금계산
        val taxAmount = BigDecimal.ZERO

        //+ 정산금액에 필요한 데이터 만들기
        val pgSalesAmount = BigDecimal.ZERO
        val commissionAmount = BigDecimal.ZERO

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