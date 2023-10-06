package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import jakarta.persistence.EntityManager
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime

@Configuration
class DailySettlementItemReaderConfig(
    private val entityManager: EntityManager,
) {

    val chunkSize = 500
    val startDateTime: ZonedDateTime = ZonedDateTime.of(
        LocalDate.now(),
        LocalTime.MIN,
        ZoneId.of("Asia/Seoul"))

    val endDateTime: ZonedDateTime = ZonedDateTime.of(
        LocalDate.now(),
        LocalTime.MAX,
        ZoneId.of("Asia/Seoul"))

    @Bean
    fun dailySettlementJpaItemReader(): JpaPagingItemReader<OrderItem> {
        val customQueryProvider = CustomPurchaseConfirmedItemQueryProvider(
            this.startDateTime, this.endDateTime
        )

        return JpaPagingItemReaderBuilder<OrderItem>()
            .name("dailySettlementJpaItemReader")
            .entityManagerFactory(this.entityManager.entityManagerFactory)
            .pageSize(this.chunkSize)
            .queryProvider(customQueryProvider)
            .build()
    }
}