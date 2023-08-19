package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.OrderItemRepository
import org.springframework.batch.item.Chunk
import org.springframework.transaction.annotation.Transactional
import org.springframework.batch.item.ItemWriter
import org.springframework.lang.NonNull
import org.springframework.stereotype.Component

@Component
@Transactional
class PurchaseConfirmedWriter(
        private val orderItemRepository: OrderItemRepository
): ItemWriter<OrderItem> {
    override fun write(@NonNull chunk: Chunk<out OrderItem>) {
        for (item in chunk.items) {
            orderItemRepository.save(item)
        }
    }
}
