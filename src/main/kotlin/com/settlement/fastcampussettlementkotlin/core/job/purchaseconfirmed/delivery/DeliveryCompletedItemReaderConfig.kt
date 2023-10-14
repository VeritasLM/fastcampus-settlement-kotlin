package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed.delivery

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.OrderItemRepository
import jakarta.persistence.EntityManager
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.*

@Configuration
class DeliveryCompletedItemReaderConfig(
    private val entityManager: EntityManager,
) {

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
    fun deliveryCompletedJpaItemReader(): JpaPagingItemReader<OrderItem> {

        val queryProvider = DeliveryCompletedJpaQueryProvider(this.startDateTime, this.endDateTime)

        return JpaPagingItemReaderBuilder<OrderItem>()
                .name("deliveryCompletedJpaItemReader")
                .entityManagerFactory(this.entityManager.entityManagerFactory) // EntityManagerFactory 주입
                .pageSize(this.chunkSize)
                .queryProvider(queryProvider)
                .build()
    }
}
