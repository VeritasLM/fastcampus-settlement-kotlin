package com.settlement.fastcampussettlementkotlin.domain.entity.order

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
data class OrderItem(
        @Id @Column(name = "order_item_no") var id: Long,
        var orderNo: Long, //주문번호
        var orderItemSnapshotNo: Long, //주문 스냅샷 번호

        var orderCount: Int? = 1, //주문수량
        var itemDeliveryStatus: Int? = 0, //주문 배송 상태

        var createdAt: ZonedDateTime? = ZonedDateTime.now(), //생성시간
        var updatedAt: ZonedDateTime? = ZonedDateTime.now(), //업데이트시간
        var deletedAt: ZonedDateTime? = null, //삭제시간
        var purchaseConfirmedAt: ZonedDateTime? = null, //구매확정일
        var shippedCompleteAt: ZonedDateTime? = null, //배송완료일

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "order_no")
        var order: Order,
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "order_item_snapshot_no")
        var orderItemSnapshot: OrderItemSnapshot
)
