package com.settlement.fastcampussettlementkotlin.infrastructure.database.repository

import com.settlement.fastcampussettlementkotlin.domain.entity.settlement.SettlementDaily
import com.settlement.fastcampussettlementkotlin.domain.entity.settlement.SettlementTotal
import org.springframework.data.jpa.repository.JpaRepository

interface SettlementTotalRepository: JpaRepository<SettlementTotal, Long>{
}