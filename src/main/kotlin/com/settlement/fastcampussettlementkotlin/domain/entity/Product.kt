package com.settlement.fastcampussettlementkotlin.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
data class Product(
        @Id @Column(name = "product_no") val id : Long,
        var createdAt: ZonedDateTime? = ZonedDateTime.now(),
        var updatedAt: ZonedDateTime? = ZonedDateTime.now(),
        var deletedAt: ZonedDateTime? = null,
        var productName: String,
        var sellerNo: Long,
        var category: Int,
        var taxType: String? = "TAX", //TAX , FREE , ZERO
        var sellPrice: BigDecimal? = BigDecimal.ZERO,
        var supplyPrice: BigDecimal? = BigDecimal.ZERO,
        var isActive: Boolean? = true,
)
