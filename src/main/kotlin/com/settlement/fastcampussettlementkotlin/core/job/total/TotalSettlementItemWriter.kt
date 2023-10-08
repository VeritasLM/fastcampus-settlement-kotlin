package com.settlement.fastcampussettlementkotlin.core.job.total

import com.settlement.fastcampussettlementkotlin.domain.entity.settlement.SettlementTotal
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.SettlementTotalRepository
import org.springframework.batch.item.Chunk
import org.springframework.batch.item.ItemWriter

class TotalSettlementItemWriter(
    private val settlementTotalRepository: SettlementTotalRepository
): ItemWriter<SettlementTotal> {

    override fun write(chunk: Chunk<out SettlementTotal>) {
        for (item in chunk.items) {
            settlementTotalRepository.save(item)
        }
    }
}