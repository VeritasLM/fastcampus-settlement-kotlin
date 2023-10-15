package com.settlement.fastcampussettlementkotlin.application

import com.settlement.fastcampussettlementkotlin.domain.PurchaseConfirmedService
import org.springframework.stereotype.Service

@Service
class PurchaseConfirmedFacade(
    private val purchaseConfirmedService: PurchaseConfirmedService,
) {

    fun orderComplete(orderNo: Long) {
        purchaseConfirmedService
    }

}