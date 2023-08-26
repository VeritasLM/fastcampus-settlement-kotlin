package com.settlement.fastcampussettlementkotlin.domain.entity.claim

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.ZonedDateTime

@Entity
data class ClaimItem(
    @Id @Column(name = "claim_item_no") val id : Long,
    var claimReceiptNo: Long,
    var createdAt: ZonedDateTime? = ZonedDateTime.now(),
    var updatedAt: ZonedDateTime? = ZonedDateTime.now(),
    var deletedAt: ZonedDateTime? = null,

    var orderItemNo: Long,
    var claimCount: Int? = 1,
)
