package com.settlement.fastcampussettlementkotlin.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.ZonedDateTime

@Entity
data class Seller(
        @Id @Column(name = "seller_no") var id: Long,
        var sellerName: String,
        var businessNo: Int? = 0,
        var sellType: String,
        var createdAt: ZonedDateTime? = ZonedDateTime.now(),
        var updatedAt: ZonedDateTime? = ZonedDateTime.now(),
        var deletedAt: ZonedDateTime? = null,
        var bankType: String? = null,
        var accountNo: Int? = null,
        var accountOwnerName: String? = null,
        var isActive: Boolean? = true,
        var defaultDeliveryAmount: Int? = 3000,
        var commission: Int? = 0,
)
