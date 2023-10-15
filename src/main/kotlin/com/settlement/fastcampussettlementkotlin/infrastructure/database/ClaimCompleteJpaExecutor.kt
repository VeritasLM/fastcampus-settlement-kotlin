package com.settlement.fastcampussettlementkotlin.infrastructure.database

import com.settlement.fastcampussettlementkotlin.domain.ClaimCompleteExecutor
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.ClaimReceiptRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class ClaimCompleteJpaExecutor(
    private val claimReceiptRepository: ClaimReceiptRepository
): ClaimCompleteExecutor {

    override fun updateCompleteAt(claimNo: Long) {
        val claimReceipt = claimReceiptRepository.findByIdOrNull(claimNo)

        val updateReceipt = claimReceipt?.copy(id=claimNo, completedAt = ZonedDateTime.now())

        claimReceiptRepository.save(updateReceipt!!)
    }
}