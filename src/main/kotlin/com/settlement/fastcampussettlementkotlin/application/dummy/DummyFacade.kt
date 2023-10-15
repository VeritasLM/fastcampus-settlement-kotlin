package com.settlement.fastcampussettlementkotlin.application.dummy

import com.settlement.fastcampussettlementkotlin.domain.entity.Product
import com.settlement.fastcampussettlementkotlin.domain.entity.Seller
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItemSnapshot
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.ClaimItemRepository
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.ClaimReceiptRepository
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.OrderItemRepository
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.OrderItemSnapshotRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.ZonedDateTime

@Service
class DummyFacade(
    private val orderItemRepository: OrderItemRepository,
    private val orderItemSnapshotRepository: OrderItemSnapshotRepository,
    private val claimReceiptRepository: ClaimReceiptRepository,
    private val claimItemRepository: ClaimItemRepository,
) {

    fun createOrder(orderNo: Long) {
        val orderItemSnapshot = OrderItemSnapshot(
            productNo = 1,
            sellerNo = 1,
            sellPrice = BigDecimal.valueOf(10000.000),
            supplyPrice = BigDecimal.valueOf(1000.000),
            promotionAmount = BigDecimal.valueOf(2000.000),
            mileageUsageAmount = BigDecimal.valueOf(2000.000),
            seller = Seller(1, sellerName = "가나다", sellType = "P"),
            product = Product(1, productName = "테스트", sellerNo = 1, category = 1)
        )
        orderItemSnapshotRepository.save(orderItemSnapshot)

        val orderItem = OrderItem(
            orderNo = orderNo,
            orderCount = 1,
            orderItemSnapshotNo = orderNo,
            itemDeliveryStatus = 0,
            shippedCompleteAt = ZonedDateTime.now(),
            orderItemSnapshot = orderItemSnapshot
        )

        orderItemRepository.save(orderItem)


    }

    fun createClaim() {

    }
}