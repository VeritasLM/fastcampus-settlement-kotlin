package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed.claim

import com.settlement.fastcampussettlementkotlin.domain.collection.NegativeDailySettlementCollection
import com.settlement.fastcampussettlementkotlin.domain.entity.claim.ClaimItem
import com.settlement.fastcampussettlementkotlin.domain.entity.settlement.SettlementDaily
import org.springframework.batch.item.ItemProcessor

class ClaimSettlementItemProcessor: ItemProcessor<ClaimItem, SettlementDaily> {

    override fun process(item: ClaimItem): SettlementDaily {
        return NegativeDailySettlementCollection(item).getSettlementDaily()
    }
}