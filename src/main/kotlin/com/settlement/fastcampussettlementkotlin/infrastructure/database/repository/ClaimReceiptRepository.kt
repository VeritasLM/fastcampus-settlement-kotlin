package com.settlement.fastcampussettlementkotlin.infrastructure.database.repository

import com.settlement.fastcampussettlementkotlin.domain.entity.claim.ClaimReceipt
import org.springframework.data.jpa.repository.JpaRepository

interface ClaimReceiptRepository: JpaRepository<ClaimReceipt, Long> {

    fun countByOrderNoAndCompletedAtIsNotNull(orderNo: Long): Int
}