package com.settlement.fastcampussettlementkotlin.infrastructure.message

import com.fasterxml.jackson.databind.ObjectMapper
import com.settlement.fastcampussettlementkotlin.domain.ClaimCompleteExecutor
import com.settlement.fastcampussettlementkotlin.infrastructure.message.data.ClaimCompleteMessage
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class ClaimCompleteProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
): ClaimCompleteExecutor {
    private val topicName = "claimComplete"
    override fun updateCompleteAt(claimNo: Long) {
        val claimCompleteMessage = ClaimCompleteMessage(claimNo, "COMPLETE")
        kafkaTemplate.send(this.topicName, claimNo.toString(), claimCompleteMessage)
    }
}