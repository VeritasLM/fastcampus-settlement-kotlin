package com.settlement.fastcampussettlementkotlin.domain.entity.settlement

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.time.ZonedDateTime

@Entity
data class SettlementDaily(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val settlementId: Long,
    @Column(nullable = false)
    val settlementDate: LocalDate,
    @Column(nullable = false)
    val sellerNo: Long,
    @Column(nullable = false)
    val sellerName: String,
    val sellerBusinessNumber: String?,
    val taxType: String?,
    val sellType: String?,
    @Column(nullable = false)
    val pgSalesAmount: BigDecimal,
    @Column(nullable = false)
    val couponDiscountAmount: BigDecimal,
    @Column(nullable = false)
    val mileageUsageAmount: BigDecimal,
    @Column(nullable = false)
    val shippingFeeAmount: BigDecimal,
    @Column(nullable = false)
    val claimShippingFeeAmount: BigDecimal,
    @Column(nullable = false)
    val commissionAmount: BigDecimal,
    val createdAt: ZonedDateTime? = ZonedDateTime.now(), //생성시간
    val updatedAt: ZonedDateTime? = ZonedDateTime.now(), //업데이트시간
    val deletedAt: ZonedDateTime? = null, //삭제시간
)
