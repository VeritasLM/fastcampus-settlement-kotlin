package com.settlement.fastcampussettlementkotlin.application

import com.settlement.fastcampussettlementkotlin.domain.ClaimCompleteService
import org.springframework.stereotype.Service

@Service
class ClaimCompleteFacade(
    private val claimCompleteService: ClaimCompleteService
){

    fun complete(claimNo: Long) {
        claimCompleteService.complete(claimNo)
    }
}