package com.settlement.fastcampussettlementkotlin.domain.entity.order

import com.settlement.fastcampussettlementkotlin.domain.entity.Product
import com.settlement.fastcampussettlementkotlin.domain.entity.Seller
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
data class OrderItemSnapshot(
        @Id @Column(name = "order_item_snapshot_no") var id: Long,

        var createdAt: ZonedDateTime? = ZonedDateTime.now(),
        var updatedAt: ZonedDateTime? = ZonedDateTime.now(),
        var deletedAt: ZonedDateTime? = null,

        var productNo: Long,
        var sellerNo: Long,
        var sellPrice: BigDecimal? = BigDecimal.ZERO,
        var supplyPrice: BigDecimal? = BigDecimal.ZERO,
        var promotionAmount: BigDecimal? = BigDecimal.ZERO,
        var defaultDeliveryAmount: BigDecimal? = BigDecimal.valueOf(3000),

        var itemCategory: Int? = 0, //TODO : Enum으로 변경
        var taxRate: Int? = 3,
        var taxType: String = "TAX", //TODO : Enum으로 변경
)
