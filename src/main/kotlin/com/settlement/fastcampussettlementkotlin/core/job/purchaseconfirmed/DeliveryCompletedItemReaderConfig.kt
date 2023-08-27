package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import jakarta.persistence.EntityManagerFactory
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime


@Configuration
class DeliveryCompletedItemReaderConfig(
    private val entityManagerFactory: EntityManagerFactory,
    private val transactionManager: PlatformTransactionManager) {

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
    fun deliveryCompletedJpaItemReader(): JpaPagingItemReader<List<OrderItem>> {
        println("StartTime:"+startDateTime+" / [endDateTime] :"+endDateTime)
        val reader = JpaPagingItemReader<List<OrderItem>>()
        reader.setEntityManagerFactory(entityManagerFactory)
        reader.setQueryString("SELECT o FROM OrderItem o WHERE o.shippedCompleteAt BETWEEN :startDate AND :endDate")
        reader.setParameterValues(
            mapOf("startDate" to startDateTime, "endDate" to endDateTime)
        )
        reader.pageSize = chunkSize
        reader.setTransacted(true) // Enable Spring's transaction management
        reader.afterPropertiesSet()

        return reader
    }
}
