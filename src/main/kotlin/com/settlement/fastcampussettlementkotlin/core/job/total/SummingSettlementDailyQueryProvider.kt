package com.settlement.fastcampussettlementkotlin.core.job.total

import com.settlement.fastcampussettlementkotlin.domain.projection.SummingSettlementResponse
import jakarta.persistence.Query
import jakarta.persistence.TypedQuery
import org.springframework.batch.item.database.orm.AbstractJpaQueryProvider
import java.time.LocalDate

class SummingSettlementDailyQueryProvider(
    private val startDate: LocalDate,
    private val endDate: LocalDate,
): AbstractJpaQueryProvider()  {
    override fun createQuery(): Query {
        val query: TypedQuery<SummingSettlementResponse> = this.entityManager.createQuery(
            "SELECT sd.sellerNo," +
                    "sd.sellerName," +
                    "sd.sellerBusinessNumber," +
                    "sd.taxType," +
                    "sd.sellType," +
                    "sum(sd.pgSalesAmount) as sumPgSalesAmount," +
                    "sum(sd.couponDiscountAmount) as sumCouponDiscountAmount," +
                    "sum(sd.mileageUsageAmount) as sumMileageUsageAmount," +
                    "sum(sd.shippingFeeAmount) as sumShippingFeeAmount," +
                    "sum(sd.claimShippingFeeAmount) as sumClaimShippingFeeAmount," +
                    "sum(sd.commissionAmount) as sumCommissionAmount " +
                    "FROM SettlementDaily sd " +
                    "WHERE sd.settlementDate BETWEEN :startDate AND :endDate " +
                    "GROUP BY sellerNo",
            SummingSettlementResponse::class.java
        )

        query.setParameter("startDate", this.startDate)
        query.setParameter("endDate", this.endDate)

        return query
    }

    override fun afterPropertiesSet() {
        TODO("Not yet implemented")
    }
}