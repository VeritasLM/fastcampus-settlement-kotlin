package com.settlement.fastcampussettlementkotlin.domain

import com.settlement.fastcampussettlementkotlin.domain.collection.NegativeDailySettlementCollection
import com.settlement.fastcampussettlementkotlin.domain.collection.PositiveDailySettlementCollection
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.ClaimItemRepository
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.OrderItemRepository
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.SettlementDailyRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class PurchaseConfirmedConsumerForSettlement(
    private val orderItemRepository: OrderItemRepository,
    private val settlementDailyRepository: SettlementDailyRepository,
) {
    @KafkaListener(topics = ["purchaseConfirmed"], groupId = "order-complete-consumer-group")
    fun listen(message: String) {
        try {
            // 메시지 처리 로직 추가
            processMessage(message)

        } catch (e: Exception) {
            // 에러 처리
            handleException(e)
        }
    }

    /**
     * message -> orderNo
     */
    private fun processMessage(message: String) {
        val claimNo = message.toLong()
        //OrderNo를 가진 OrderItem을 검색 ( List로 반환 )
        val orderItemList = orderItemRepository.findByOrderNo(claimNo)

        val settlementDailyList = orderItemList.map{
            PositiveDailySettlementCollection(it).getSettlementDaily()
        }

        settlementDailyRepository.saveAll(settlementDailyList)
    }

    private fun handleException(e: Exception) {
        // 예외 처리 로직을 이곳에 구현
    }
}