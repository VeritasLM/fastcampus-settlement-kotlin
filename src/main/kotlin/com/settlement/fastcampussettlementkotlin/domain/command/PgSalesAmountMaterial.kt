package com.settlement.fastcampussettlementkotlin.domain.command

import org.springframework.boot.context.properties.bind.DefaultValue
import java.math.BigDecimal

data class PgSalesAmountMaterial(
    val sellPrice: BigDecimal? = BigDecimal.ZERO,
    val promotionAmount: BigDecimal? = BigDecimal.ZERO,
    val mileageUsageAmount: BigDecimal? = BigDecimal.ZERO,
)
