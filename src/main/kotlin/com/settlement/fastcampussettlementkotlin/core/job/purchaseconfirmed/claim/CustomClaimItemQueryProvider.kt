package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed.claim

import com.settlement.fastcampussettlementkotlin.domain.entity.order.ClaimItem
import jakarta.persistence.Query
import jakarta.persistence.TypedQuery
import org.springframework.batch.item.database.orm.AbstractJpaQueryProvider

class CustomClaimItemQueryProvider: AbstractJpaQueryProvider() {

    /**
    SELECT ci.*
    FROM claim_item ci
    LEFT OUTER JOIN settlement_daily sd
    ON sd.claim_receipt_no = ci.claim_receipt_no
    JOIN claim_receipt cr
    ON ci.claim_receipt_no = cr.claim_receipt_no
    WHERE cr.completed_at IS NOT NULL
    AND sd.settlement_id IS NULL
     */
    override fun createQuery(): Query {
        val query: TypedQuery<ClaimItem> = this.entityManager.createQuery(
            "SELECT ci FROM ClaimItem ci " +
                    "LEFT OUTER JOIN SettlementDaily sd ON sd.claimReceiptNo = ci.claimReceiptNo " +
                    "JOIN ClaimReceipt cr ON ci.claimReceiptNo = cr.id " +
                    "WHERE cr.completedAt IS NOT NULL AND sd.id IS NULL"
            , ClaimItem::class.java
        )

        return query
    }

    override fun afterPropertiesSet() {
        TODO("Not yet implemented")
    }
}