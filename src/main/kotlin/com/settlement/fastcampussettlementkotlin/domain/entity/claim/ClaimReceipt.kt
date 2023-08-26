package com.settlement.fastcampussettlementkotlin.domain.entity.claim

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.ZonedDateTime

@Entity
data class ClaimReceipt(
    @Id @Column(name = "claim_receipt_no") val id : Long,
    var orderNo: Long,

    var createdAt: ZonedDateTime? = ZonedDateTime.now(),
    var updatedAt: ZonedDateTime? = ZonedDateTime.now(),
    var deletedAt: ZonedDateTime? = null,
    var completedAt: ZonedDateTime? = null,

    var requestType: String, //TODO ENUM으로
    var claimStatus: Int, //TODO ENUM으로
    var extraFeePayer: Int, //TODO ENUM으로
    var claimReason: Int, //TODO ENUM으로
)
