package com.settlement.fastcampussettlementkotlin.domain

import com.settlement.fastcampussettlementkotlin.domain.collection.NegativeDailySettlementCollection
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.ClaimItemRepository
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.SettlementDailyRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class ClaimCompleteConsumerForSettlement(
    private val claimItemRepository: ClaimItemRepository,
    private val settlementDailyRepository: SettlementDailyRepository,
) {
    @KafkaListener(topics = ["claimComplete"], groupId = "test-consumer-group")
    fun listen(message: String) {
        try {
            // 메시지 처리 로직 추가
            processMessage(message)

            // 처리 성공 시, 메시지 커밋 (Kafka에서 해당 메시지를 읽음 표시)

        } catch (e: Exception) {
            // 에러 처리
            handleException(e)

            // 처리 실패 시, 메시지 리밸런싱 또는 재시도 설정 (Kafka에서 다시 읽음 표시)
        }
    }

    private fun processMessage(message: String) {
        // 메시지 처리 로직을 이곳에 구현
        val claimItem = claimItemRepository.findById(message.toLong())

        claimItem.ifPresent {
            System.out.println("Saving Settlement!")
            val settlementDaily = NegativeDailySettlementCollection(it).getSettlementDaily()
            System.out.println(settlementDaily)
            settlementDailyRepository.save(settlementDaily)
        }

    }

    private fun handleException(e: Exception) {
        // 예외 처리 로직을 이곳에 구현
        println("Error occurred: ${e.message}")
        // 예외 처리를 수행하고 필요한 조치를 취함 (예: 로깅, 경고, 재시도 등)
    }
}