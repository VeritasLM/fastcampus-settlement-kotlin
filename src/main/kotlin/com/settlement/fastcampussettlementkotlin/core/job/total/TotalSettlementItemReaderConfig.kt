package com.settlement.fastcampussettlementkotlin.core.job.total

import com.settlement.fastcampussettlementkotlin.domain.projection.SummingSettlementResponse
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.OrderItemRepository
import jakarta.persistence.EntityManager
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate

@Configuration
class TotalSettlementItemReaderConfig(
    private val entityManager: EntityManager,
) {

    private val chunkSize = 500
    private val currentDate: LocalDate = LocalDate.now()

    @Bean
    fun totalSettlementJpaItemReader(orderItemRepository: OrderItemRepository): JpaPagingItemReader<SummingSettlementResponse> {
        val queryProvider = SummingSettlementDailyQueryProvider(getFirstDate(), getLastDate())

        return JpaPagingItemReaderBuilder<SummingSettlementResponse>()
            .name("totalSettlementJpaItemReader")
            .entityManagerFactory(entityManager.entityManagerFactory) // EntityManagerFactory 주입
            .pageSize(chunkSize)
            .queryProvider(queryProvider)
            .build()
    }


    private fun getFirstDate(): LocalDate {
        val year = this.currentDate.year
        val month = this.currentDate.month

        return if (month.value == 1) {
            LocalDate.of(year - 1, 12, 1)
        } else {
            LocalDate.of(year, month.minus(1), 1)
        }
    }

    private fun getLastDate(): LocalDate {
        return this.currentDate.withDayOfMonth(1)
    }
}