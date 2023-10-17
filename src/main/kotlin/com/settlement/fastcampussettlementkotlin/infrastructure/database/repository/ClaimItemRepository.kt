package com.settlement.fastcampussettlementkotlin.infrastructure.database.repository

import com.settlement.fastcampussettlementkotlin.domain.entity.claim.ClaimItem
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime
import java.time.ZonedDateTime

interface ClaimItemRepository : JpaRepository<ClaimItem, Long> {

    fun findByClaimReceiptNo(claimNo: Long): List<ClaimItem>
}

