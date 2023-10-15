package com.settlement.fastcampussettlementkotlin.domain.collection

import com.settlement.fastcampussettlementkotlin.domain.command.PgSalesAmountMaterial
import com.settlement.fastcampussettlementkotlin.domain.entity.Product
import com.settlement.fastcampussettlementkotlin.domain.entity.Seller
import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItemSnapshot
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class PgSalesAmountCalculatorTest{
    @DisplayName("프로모션도 없고, 적립금 사용도 없는 경우 ")
    @Test
    fun test1() {
        val orderItemSnapshot = OrderItemSnapshot(
            1,
            sellerNo = 1,
            productNo = 1,
            sellPrice = BigDecimal.valueOf(10000.000),
            supplyPrice = BigDecimal.valueOf(8000.000),
            promotionAmount = BigDecimal.valueOf(0.000),
            mileageUsageAmount = BigDecimal.ZERO,
            seller = Seller(1,
                "니모",
                sellType = "P"),
            product = Product(1, productName = "어항1", sellerNo = 1,
                sellPrice = BigDecimal.valueOf(10000.000),
                supplyPrice = BigDecimal.valueOf(8000.000),
                category = 1),
        )

        //val pgSalesAmountMaterial = PgSalesAmountMaterial(
        //    BigDecimal.valueOf(10000.000),
        //    BigDecimal.valueOf(0.000),
        //    BigDecimal.valueOf(0.000),
        //)
        val calculator = PgSalesAmountCalculator(orderItemSnapshot)
        val pgSalesAmount = calculator.getPgSaleAmount()

        Assertions.assertEquals(pgSalesAmount, BigDecimal.valueOf(10000.0))
    }
}