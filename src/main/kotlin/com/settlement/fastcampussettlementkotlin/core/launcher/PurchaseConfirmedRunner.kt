package com.settlement.fastcampussettlementkotlin.core.launcher

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.stereotype.Component


@Component
class PurchaseConfirmedRunner(
    private val jobLauncher: JobLauncher,
    private val purchaseConfirmedJob: Job
) {

    @Throws(Exception::class)
    fun runJob() {
        val jobExecution = jobLauncher.run(purchaseConfirmedJob, JobParameters())
        println("Job Execution Status: " + jobExecution.status)
    }
}