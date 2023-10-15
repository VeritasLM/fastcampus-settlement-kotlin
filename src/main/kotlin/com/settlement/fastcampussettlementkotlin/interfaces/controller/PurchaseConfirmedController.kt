package com.settlement.fastcampussettlementkotlin.interfaces.controller

import com.settlement.fastcampussettlementkotlin.application.PurchaseConfirmedFacade
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order/purchase-confirmed")
class PurchaseConfirmedController(
    private val purchaseConfirmedFacade: PurchaseConfirmedFacade
) {

    @PutMapping("/order_no/{orderNo}")
    fun completedOrder(@PathVariable orderNo: Long) {
        purchaseConfirmedFacade.orderComplete(orderNo)
    }
}