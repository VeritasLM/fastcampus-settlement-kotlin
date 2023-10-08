package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed.delivery

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import jakarta.persistence.Query
import jakarta.persistence.TypedQuery
import org.springframework.batch.item.database.orm.AbstractJpaQueryProvider
import java.time.ZonedDateTime

class DeliveryCompletedJpaQueryProvider(
    private val startDateTime: ZonedDateTime,
    private val endDateTime: ZonedDateTime,
): AbstractJpaQueryProvider() {

    /**
    SELECT oi.*
    FROM order_item oi
    LEFT OUTER JOIN claim_receipt cr ON oi.order_no = cr.order_no
    WHERE oi.shipped_complete_at BETWEEN ? AND ?
    AND oi.purchase_confirmed_at IS NULL
    AND (cr.orderNo IS NULL or cr.completed_at IS NOT NULL);
     */
    override fun createQuery(): Query {
        val query: TypedQuery<OrderItem> = this.entityManager.createQuery(
            "SELECT oi FROM OrderItem oi " +
                    "LEFT OUTER JOIN ClaimReceipt cr ON oi.orderNo = cr.orderNo " +
                    "WHERE oi.shippedCompleteAt BETWEEN :startDateTime AND :endDateTime " +
                    "AND oi.purchaseConfirmedAt IS NULL " +
                    "AND (cr.orderNo IS NULL or cr.completedAt IS NOT NULL)",
            OrderItem::class.java
        )

        query.setParameter("startDateTime", this.startDateTime)
        query.setParameter("endDateTime", this.endDateTime)

        return query
    }

    override fun afterPropertiesSet() {
        TODO("Not yet implemented")
    }
}