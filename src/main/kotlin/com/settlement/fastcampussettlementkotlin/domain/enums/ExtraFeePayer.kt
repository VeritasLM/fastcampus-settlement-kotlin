package com.settlement.fastcampussettlementkotlin.domain.enums

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

enum class ExtraFeePayer(val value: Int) {
    BUYER(0), 
    SELLER(1), 
    PLATFORM(2)
}

@Converter
class ExtraFeePayerConverter : AttributeConverter<ExtraFeePayer, Int> {
    override fun convertToDatabaseColumn(attribute: ExtraFeePayer?): Int {
        return attribute?.value ?: throw IllegalArgumentException("Invalid ExtraFeePayer value")
    }

    override fun convertToEntityAttribute(dbData: Int?): ExtraFeePayer {
        return when (dbData) {
            0 -> ExtraFeePayer.BUYER
            1 -> ExtraFeePayer.SELLER
            2 -> ExtraFeePayer.PLATFORM
            else -> throw IllegalArgumentException("Invalid ExtraFeePayer value: $dbData")
        }
    }
}