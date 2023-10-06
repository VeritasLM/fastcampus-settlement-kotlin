package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import jakarta.persistence.Query
import jakarta.persistence.TypedQuery
import org.springframework.batch.item.database.orm.AbstractJpaQueryProvider
import java.time.ZonedDateTime

class CustomPurchaseConfirmedItemQueryProvider(
    private val startDateTime: ZonedDateTime,
    private val endDateTime: ZonedDateTime,
): AbstractJpaQueryProvider() {
    override fun createQuery(): Query {
        val query: TypedQuery<OrderItem> = this.entityManager.createQuery(
            "SELECT oi FROM OrderItem oi " +
                    "WHERE purchaseConfirmedAt BETWEEN :startDateTime AND :endDateTime",
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