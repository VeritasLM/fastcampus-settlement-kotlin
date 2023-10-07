package com.settlement.fastcampussettlementkotlin.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
data class Product(
        @Id @Column(name = "product_no") val id : Long,
        val createdAt: ZonedDateTime? = ZonedDateTime.now(),
        val updatedAt: ZonedDateTime? = ZonedDateTime.now(),
        val deletedAt: ZonedDateTime? = null,
        val productName: String,
        val sellerNo: Long,
        val category: Int,
        val taxType: String? = "TAX", //TAX , FREE , ZERO
        val sellPrice: BigDecimal? = BigDecimal.ZERO,
        val supplyPrice: BigDecimal? = BigDecimal.ZERO,
        val isActive: Boolean? = true,
)
