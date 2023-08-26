package com.settlement.fastcampussettlementkotlin.domain.entity.claim

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(schema = "commerce", name = "order")
data class ClaimItem(
    @Id @Column(name = "claim_item_no") val id : Long,
    val claimReceiptNo: Long,
    val createdAt: ZonedDateTime? = ZonedDateTime.now(),
    val updatedAt: ZonedDateTime? = ZonedDateTime.now(),
    val deletedAt: ZonedDateTime? = null,

    val orderItemNo: Long,
    val claimCount: Int? = 1,
)
