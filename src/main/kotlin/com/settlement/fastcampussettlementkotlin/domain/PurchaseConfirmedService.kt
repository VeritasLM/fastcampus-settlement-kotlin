package com.settlement.fastcampussettlementkotlin.domain

import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.ClaimReceiptRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.lang.Exception
import java.lang.RuntimeException
import kotlin.jvm.Throws

@Service
class PurchaseConfirmedService(
    private val executor: OrderPurchaseConfirmedExecutor,
    private val claimReceiptRepository: ClaimReceiptRepository,
) {
    @Throws(Exception::class)
    fun complete(orderNo: Long) = executor.confirmed(orderNo)

}
