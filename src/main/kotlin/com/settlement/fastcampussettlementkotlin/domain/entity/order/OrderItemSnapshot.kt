package com.settlement.fastcampussettlementkotlin.domain.entity.order

import com.settlement.fastcampussettlementkotlin.domain.entity.Product
import com.settlement.fastcampussettlementkotlin.domain.entity.Seller
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
@Table(schema = "commerce", name = "Order_item_snapshot")
data class OrderItemSnapshot(
        @Id @Column(name = "order_item_snapshot_no") val id: Long,

        val createdAt: ZonedDateTime? = ZonedDateTime.now(),
        val updatedAt: ZonedDateTime? = ZonedDateTime.now(),
        val deletedAt: ZonedDateTime? = null,

        val productNo: Long,
        val sellerNo: Long,

        val sellPrice: BigDecimal? = BigDecimal.ZERO,
        val supplyPrice: BigDecimal? = BigDecimal.ZERO,
        val promotionAmount: BigDecimal? = BigDecimal.ZERO,
        val defaultDeliveryAmount: BigDecimal? = BigDecimal.valueOf(3000),

        val itemCategory: Int? = 0, //TODO : Enum으로 변경
        val taxRate: Int? = 3,
        val taxType: String = "TAX", //TODO : Enum으로 변경
)
