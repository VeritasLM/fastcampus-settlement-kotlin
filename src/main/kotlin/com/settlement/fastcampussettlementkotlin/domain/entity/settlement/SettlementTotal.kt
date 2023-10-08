package com.settlement.fastcampussettlementkotlin.domain.entity.settlement

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.time.ZonedDateTime

@Entity
data class SettlementTotal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="settlement_total_id", nullable = false)
    val id: Long? = null,
    @Column(nullable = false)
    val settlementDate: LocalDate,
    @Column(nullable = false)
    val sellerNo: Long,
    @Column(nullable = false)
    val sellerName: String,
    val sellerBusinessNumber: String?,
    val taxType: String? = "TAX",
    val sellType: String? = "CONSIGNMENT",
    @Column(nullable = false)
    val pgSalesAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val couponDiscountAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val mileageUsageAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val shippingFeeAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val claimShippingFeeAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val commissionAmount: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = false)
    val taxAmount: BigDecimal? = BigDecimal.ZERO,
    val createdAt: ZonedDateTime? = ZonedDateTime.now(), //생성시간
    val updatedAt: ZonedDateTime? = ZonedDateTime.now(), //업데이트시간
    val deletedAt: ZonedDateTime? = null, //삭제시간
)
