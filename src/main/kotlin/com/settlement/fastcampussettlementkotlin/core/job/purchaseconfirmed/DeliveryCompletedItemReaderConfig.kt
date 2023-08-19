package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.OrderItemRepository
import org.springframework.batch.item.data.RepositoryItemReader
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.Sort

@Configuration
class DeliveryCompletedItemReaderConfig {

    val chunkSize = 500
    @Bean
    fun deliveryCompletedJpaItemReader(orderItemRepository: OrderItemRepository): RepositoryItemReader<OrderItem> {
        return RepositoryItemReaderBuilder<OrderItem>()
                .name("deliveryCompletedJpaItemReader")
                .repository(orderItemRepository)
                .methodName("findAll")
                .pageSize(chunkSize)
                .sorts(mapOf("shippedCompleteAt" to Sort.Direction.ASC))
                .build()
    }
}
