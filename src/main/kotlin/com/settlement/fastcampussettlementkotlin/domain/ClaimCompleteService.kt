package com.settlement.fastcampussettlementkotlin.domain

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class ClaimCompleteService(
    @Qualifier("claimCompleteProducer") private val executor: ClaimCompleteExecutor
) {
    fun complete(claimNo: Long) = executor.updateCompleteAt(claimNo)

}
