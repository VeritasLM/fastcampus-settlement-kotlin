package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed.daily

import com.settlement.fastcampussettlementkotlin.domain.collection.CommissionAmountCalculator
import com.settlement.fastcampussettlementkotlin.domain.collection.PgSalesAmountCalculator
import com.settlement.fastcampussettlementkotlin.domain.collection.PositiveDailySettlementCollection
import com.settlement.fastcampussettlementkotlin.domain.collection.TaxCalculator
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import com.settlement.fastcampussettlementkotlin.domain.entity.settlement.SettlementDaily
import org.springframework.batch.item.ItemProcessor
import java.time.LocalDate

class DailySettlementItemProcessor: ItemProcessor<OrderItem, SettlementDaily> {

    /**
     * + 정산금액을 만들기
     */
    override fun process(item: OrderItem): SettlementDaily {
        val positiveDailySettlementCollection = PositiveDailySettlementCollection(item)

        return positiveDailySettlementCollection.getSettlementDaily()
    }
}