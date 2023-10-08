package com.settlement.fastcampussettlementkotlin.domain.entity.claim

import com.settlement.fastcampussettlementkotlin.domain.enums.*
import jakarta.persistence.Convert
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.ZonedDateTime


@Entity
data class ClaimReceipt(
    @Id @Column(name = "claim_receipt_no") val id : Long,
    val orderNo: Long,

    val createdAt: ZonedDateTime? = ZonedDateTime.now(),
    val updatedAt: ZonedDateTime? = ZonedDateTime.now(),
    val deletedAt: ZonedDateTime? = null,
    val completedAt: ZonedDateTime? = null,

    @Convert(converter = ClaimTypeConverter::class)
    val requestType: ClaimType, //TODO ENUM으로
    @Convert(converter = ClaimStatusConverter::class)
    val claimStatus: ClaimStatus,

    @Convert(converter = ExtraFeePayerConverter::class)
    val extraFeePayer: ExtraFeePayer, //TODO ENUM으로
    val claimReason: Int, //TODO ENUM으로
)