package com.settlement.fastcampussettlementkotlin.core.job.total

import com.settlement.fastcampussettlementkotlin.domain.entity.settlement.SettlementTotal
import com.settlement.fastcampussettlementkotlin.domain.projection.SummingSettlementResponse
import com.settlement.fastcampussettlementkotlin.infrastructure.database.repository.SettlementTotalRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
class TotalSettlementJobConfig(
    private val jobRepository: JobRepository,
    private val transactionManager: PlatformTransactionManager,
    @Qualifier("totalSettlementJpaItemReader") private val totalSettlementJpaItemReader: JpaPagingItemReader<SummingSettlementResponse>,
    private val settlementTotalRepository: SettlementTotalRepository,
) {

    private val JOB_NAME = "totalSettlementJob"
    private val chunkSize = 500

    @Bean
    fun totalSettlementJob(): Job {
        return JobBuilder(JOB_NAME, this.jobRepository)
            .start(totalSettlementJobStep())
            .build()
    }

    @Bean
    @JobScope
    fun totalSettlementJobStep(): Step {
        return StepBuilder(JOB_NAME+"_step", this.jobRepository)
            .chunk<SummingSettlementResponse, SettlementTotal>(this.chunkSize, this.transactionManager)
            .reader(totalSettlementJpaItemReader)
            .processor(totalSettlementItemProcessor())
            .writer(totalSettlementItemWriter())
            .build()
    }

    @Bean
    fun totalSettlementItemProcessor() = TotalSettlementItemProcessor()

    @Bean
    fun totalSettlementItemWriter() = TotalSettlementItemWriter(settlementTotalRepository)
}










