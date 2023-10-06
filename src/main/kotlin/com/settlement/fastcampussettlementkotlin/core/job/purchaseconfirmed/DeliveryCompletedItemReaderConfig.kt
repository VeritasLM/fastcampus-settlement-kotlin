package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.OrderItemRepository
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.*

@Configuration
class DeliveryCompletedItemReaderConfig {

    val chunkSize = 500
    val startDateTime: ZonedDateTime = ZonedDateTime.of(
            LocalDate.now().minusDays(1),
            LocalTime.MIN,
            ZoneId.of("Asia/Seoul"))

    val endDateTime: ZonedDateTime = ZonedDateTime.of(
            LocalDate.now().plusDays(1),
            LocalTime.MIN,
            ZoneId.of("Asia/Seoul"))

    @Bean
    fun deliveryCompletedJpaItemReader(orderItemRepository: OrderItemRepository): JpaPagingItemReader<OrderItem> {

        val queryProvider = DeliveryCompletedJpaQueryProvider(this.startDateTime, this.endDateTime)

        return JpaPagingItemReaderBuilder<OrderItem>()
                .name("deliveryCompletedJpaItemReader")
                .pageSize(this.chunkSize)
                .queryProvider(queryProvider)
                .build()
    }
}
