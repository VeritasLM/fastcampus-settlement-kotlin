package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import org.springframework.batch.item.ItemReader
import org.springframework.context.annotation.Configuration

@Configuration
class DeliveryCompletedItemReaderConfig: ItemReader<OrderItem> {

    override fun read(): OrderItem? {
        TODO("Not yet implemented")
    }

}
