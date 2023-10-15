package com.settlement.fastcampussettlementkotlin.infrastructure.message

import com.settlement.fastcampussettlementkotlin.domain.OrderPurchaseConfirmedExecutor
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class OrderPurchaseConfirmedProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
): OrderPurchaseConfirmedExecutor {
    private val topicName = "purchaseConfirmed"

    override fun confirmed(orderNo: Long) {
        kafkaTemplate.send(this.topicName, orderNo.toString(), orderNo)
    }
}