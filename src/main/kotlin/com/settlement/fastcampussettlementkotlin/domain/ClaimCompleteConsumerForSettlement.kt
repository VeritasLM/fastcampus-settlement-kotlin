package com.settlement.fastcampussettlementkotlin.domain

import com.fasterxml.jackson.databind.ObjectMapper
import com.settlement.fastcampussettlementkotlin.domain.collection.NegativeDailySettlementCollection
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.ClaimItemRepository
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.SettlementDailyRepository
import com.settlement.fastcampussettlementkotlin.infrastructure.message.data.ClaimCompleteMessage
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class ClaimCompleteConsumerForSettlement(
    private val claimItemRepository: ClaimItemRepository,
    private val settlementDailyRepository: SettlementDailyRepository,
) {
    @KafkaListener(topics = ["claimComplete"], groupId = "claim-consumer-group")
    fun listen(message: String) {
        try {
            // 메시지 처리 로직 추가
            processMessage(message)
            System.out.println("정산 컨슈머: $message")

        } catch (e: Exception) {
            // 에러 처리
            handleException(e)
        }
    }

    /**
     * message : ClaimCompleteMessage 직렬화
     *
     * {"claimNo": 1, "status": "COMPLETE"}
     */
    private fun processMessage(message: String) {

        //역직렬화
        val mapper = ObjectMapper()
        val deserializeMessage = mapper.readValue(message, ClaimCompleteMessage::class.java)

        val claimNo = deserializeMessage.claimNo

        val claimItemList = claimItemRepository.findByClaimReceiptNo(claimNo)

        val settlementDailyList = claimItemList.map {
            NegativeDailySettlementCollection(it).getSettlementDaily()
        }

        settlementDailyRepository.saveAll(settlementDailyList)
    }

    private fun handleException(e: Exception) {
        // 예외 처리 로직을 이곳에 구현
    }
}