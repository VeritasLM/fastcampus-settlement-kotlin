package com.settlement.fastcampussettlementkotlin.domain

import java.math.BigDecimal

sealed class TaxTypeItem {
    data class TaxItem(val price: BigDecimal? = BigDecimal.ZERO): TaxTypeItem()
    data class ZeroTaxItem(val price: BigDecimal? = BigDecimal.ZERO): TaxTypeItem()
    data class TaxFreeItem(val price: BigDecimal? = BigDecimal.ZERO): TaxTypeItem()
}