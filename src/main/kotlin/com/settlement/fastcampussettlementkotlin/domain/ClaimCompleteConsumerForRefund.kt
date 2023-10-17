package com.settlement.fastcampussettlementkotlin.domain

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ClaimCompleteConsumerForRefund {

    @KafkaListener(topics = ["claimComplete"], groupId = "refund-consumer-group")
    fun listen(message: String) {
        try {
            // 메시지 처리 로직 추가
            System.out.println("환불 컨슈머: $message")

        } catch (e: Exception) {
            // 에러 처리
        }
    }
}