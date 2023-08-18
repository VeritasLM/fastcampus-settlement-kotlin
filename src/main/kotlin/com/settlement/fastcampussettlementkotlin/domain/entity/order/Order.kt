package com.settlement.fastcampussettlementkotlin.domain.entity.order

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
data class Order(
        @Id @Column(name = "order_no") var id: Long,
        var createdAt: ZonedDateTime? = ZonedDateTime.now(),
        var updatedAt: ZonedDateTime? = ZonedDateTime.now(),
        var deletedAt: ZonedDateTime? = null,
        var paidConfirmedAt: ZonedDateTime? = null,

        var paidPgAmount: BigDecimal? = BigDecimal.ZERO,
        var usedMileageAmount: BigDecimal? = BigDecimal.ZERO,
        var couponDiscountAmount: BigDecimal? = BigDecimal.ZERO,
)
