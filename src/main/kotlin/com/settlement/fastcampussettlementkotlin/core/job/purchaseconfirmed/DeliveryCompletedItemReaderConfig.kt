package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.OrderItemRepository
import org.springframework.batch.item.data.RepositoryItemReader
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.Sort
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
    fun deliveryCompletedJpaItemReader(orderItemRepository: OrderItemRepository): RepositoryItemReader<OrderItem> {
        return RepositoryItemReaderBuilder<OrderItem>()
                .name("deliveryCompletedJpaItemReader")
                .repository(orderItemRepository)
                .methodName("findByShippedCompleteAtBetween")
                .arguments(startDateTime, endDateTime)
                .pageSize(this.chunkSize) //TODO : 주입 받는 파라미터로 분리
                .sorts(mapOf("shippedCompleteAt" to Sort.Direction.ASC))
                .build()
    }
}
