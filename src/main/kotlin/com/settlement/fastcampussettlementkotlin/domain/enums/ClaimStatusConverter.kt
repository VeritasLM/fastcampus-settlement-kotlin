package com.settlement.fastcampussettlementkotlin.domain.enums

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter


@Converter
class ClaimStatusConverter : AttributeConverter<ClaimStatus, Int> {
    override fun convertToDatabaseColumn(attribute: ClaimStatus?): Int {
        return attribute?.value ?: throw IllegalArgumentException("Invalid ClaimStatus value")
    }

    override fun convertToEntityAttribute(dbData: Int?): ClaimStatus {
        return when (dbData) {
            0 -> ClaimStatus.WITHDRAWN
            1 -> ClaimStatus.RECEIVED
            2 -> ClaimStatus.IN_PROGRESS
            3 -> ClaimStatus.COMPLETED
            else -> throw IllegalArgumentException("Invalid ClaimStatus value: $dbData")
        }
    }
}
