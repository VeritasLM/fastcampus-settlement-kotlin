package com.settlement.fastcampussettlementkotlin.infrastructure.message

import com.settlement.fastcampussettlementkotlin.domain.ClaimCompleteExecutor
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class ClaimCompleteProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
): ClaimCompleteExecutor {
    private val topicName = "claimComplete"
    override fun updateCompleteAt(claimNo: Long) {
        kafkaTemplate.send(this.topicName, claimNo.toString(), claimNo)
    }
}