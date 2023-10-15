package com.settlement.fastcampussettlementkotlin.infrastructure.database.repository

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItemSnapshot
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime
import java.time.ZonedDateTime

interface OrderItemSnapshotRepository : JpaRepository<OrderItemSnapshot, Long> {
}
