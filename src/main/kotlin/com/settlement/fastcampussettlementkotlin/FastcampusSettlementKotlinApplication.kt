package com.settlement.fastcampussettlementkotlin

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableBatchProcessing
class FastcampusSettlementKotlinApplication

fun main(args: Array<String>) {
    runApplication<FastcampusSettlementKotlinApplication>(*args)
}
