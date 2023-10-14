package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed.daily

import com.settlement.fastcampussettlementkotlin.domain.entity.settlement.SettlementDaily
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.SettlementDailyRepository
import org.springframework.batch.item.Chunk
import org.springframework.batch.item.ItemWriter
import org.springframework.context.annotation.Configuration

class DailySettlementItemWriter(
    private val settlementDailyRepository: SettlementDailyRepository
): ItemWriter<SettlementDaily> {

    override fun write(chunk: Chunk<out SettlementDaily>) {
        for (item in chunk.items) {
            settlementDailyRepository.save(item)
        }
    }
}