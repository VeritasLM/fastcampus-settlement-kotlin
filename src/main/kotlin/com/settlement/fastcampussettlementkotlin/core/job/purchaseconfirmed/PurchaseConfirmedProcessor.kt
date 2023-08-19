package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import org.springframework.batch.item.ItemProcessor
import java.time.ZonedDateTime

class PurchaseConfirmedProcessor: ItemProcessor<OrderItem, OrderItem> {
    override fun process(item: OrderItem): OrderItem {
        return item.copy(purchaseConfirmedAt = ZonedDateTime.now())
    }
}
