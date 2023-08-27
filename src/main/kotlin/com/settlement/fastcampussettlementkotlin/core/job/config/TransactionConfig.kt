package com.settlement.fastcampussettlementkotlin.core.job.config

import jakarta.persistence.EntityManagerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.support.TransactionTemplate

@Configuration
@EnableTransactionManagement
class TransactionConfig {

    @Bean
    fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }

    @Bean
    fun transactionTemplate(transactionManager: PlatformTransactionManager): TransactionTemplate {
        return TransactionTemplate(transactionManager)
    }
}
