package com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed

import com.settlement.fastcampussettlementkotlin.domain.entity.order.OrderItem
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.batch.core.*
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.*

@ExtendWith(SpringExtension::class)
@DataJpaTest
@EnableBatchProcessing
@ComponentScan(basePackages = ["com.settlement.fastcampussettlementkotlin.core.job.purchaseconfirmed"]) // 배치 컴포넌트 패키지 경로 지정
@ContextConfiguration(classes = [PurchaseConfirmedJobConfig::class]) // 배치 설정 클래스 지정
@Transactional
class RepositoryItemReaderTest {

    @Autowired
    private lateinit var entityManager: TestEntityManager

    @Autowired
    private lateinit var jobLauncher: JobLauncher

    @Autowired
    private lateinit var job: Job

    @Test
    fun testRepositoryItemReader() {
        val startDateTime: ZonedDateTime = ZonedDateTime.of(
            LocalDate.now().minusDays(1),
            LocalTime.MIN,
            ZoneId.of("Asia/Seoul")
        )
        val endDateTime: ZonedDateTime = ZonedDateTime.of(
            LocalDate.now().plusDays(1),
            LocalTime.MIN,
            ZoneId.of("Asia/Seoul")
        )

        // 생성된 데이터를 entityManager를 통해 데이터베이스에 저장 (테스트 데이터 생성)
        val zoneId = ZoneId.of("Asia/Seoul")
        val orderItem = OrderItem(
            id = 1L,
            orderNo=1L,
            orderItemSnapshotNo=1L,
            shippedCompleteAt = ZonedDateTime.of(2023, 8, 20, 11, 44, 39, 0, zoneId),
            createdAt = ZonedDateTime.of(2023, 8, 20, 11, 44, 39, 0, zoneId),
            updatedAt = ZonedDateTime.of(2023, 8, 20, 11, 44, 39, 0, zoneId)
        )
        entityManager.persist(orderItem)
        entityManager.flush()

        // JobParameters를 생성하여 직접 넘기기
        val jobParameters: JobParameters = JobParametersBuilder()
            .addString("startDateTime", startDateTime.toString())
            .addString("endDateTime", endDateTime.toString())
            .toJobParameters()
        // 배치 잡 실행
        val jobExecution: JobExecution = jobLauncher.run(job, jobParameters)

        // 배치 잡 실행 결과 확인
        assertEquals(BatchStatus.COMPLETED, jobExecution.status)
    }

}
