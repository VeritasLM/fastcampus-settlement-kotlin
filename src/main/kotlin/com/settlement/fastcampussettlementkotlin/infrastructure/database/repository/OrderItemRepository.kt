package com.settlement.fastcampussettlementkotlin.infrastructure.database.repository

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository : JpaRepository<OrderItem, Long>, OrderItemPurchaseConfirmedCustomerRepository {

}
