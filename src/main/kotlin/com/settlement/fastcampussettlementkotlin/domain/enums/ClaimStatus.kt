package com.settlement.fastcampussettlementkotlin.domain.enums

enum class ClaimStatus(val value: Int) {
    WITHDRAWN(0),
    RECEIVED(1),
    IN_PROGRESS(2),
    COMPLETED(3)
}