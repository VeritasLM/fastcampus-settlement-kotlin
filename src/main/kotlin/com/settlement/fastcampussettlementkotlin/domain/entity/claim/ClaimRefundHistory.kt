package com.settlement.fastcampussettlementkotlin.domain.entity.claim

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
data class ClaimRefundHistory(

    @Id @Column(name = "claim_refund_no") val id : Long,
    val claimReceiptNo: Long,
    val createdAt: ZonedDateTime? = ZonedDateTime.now(),
    val updatedAt: ZonedDateTime? = ZonedDateTime.now(),
    val deletedAt: ZonedDateTime? = null,

    val refundedAt: ZonedDateTime? = null, //환불시간

    val sellerNo: Long,
    val refundCashAmount: BigDecimal = BigDecimal.ZERO,
    val couponSaleAmount: BigDecimal = BigDecimal.ZERO,
    val refundMileageAmount: BigDecimal = BigDecimal.ZERO,
    val subtractDeliveryAmount: BigDecimal = BigDecimal.ZERO,
    val refundDeliveryAmount: BigDecimal = BigDecimal.ZERO,
)
