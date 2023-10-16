package com.settlement.fastcampussettlementkotlin.core.listener

import net.gpedro.integrations.slack.SlackApi
import net.gpedro.integrations.slack.SlackAttachment
import net.gpedro.integrations.slack.SlackMessage
import org.springframework.batch.core.ChunkListener
import org.springframework.batch.core.scope.context.ChunkContext
import java.util.*


class PurchaseConfirmedChunkListener: ChunkListener {

    private val slackWebhookUrl = "https://hooks.slack.com/services/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"
    override fun beforeChunk(context: ChunkContext) {
        sendMessage(SlackMessage("PurchaseConfirmedChunkListener::START!!"))
        super.beforeChunk(context)
    }

    override fun afterChunk(context: ChunkContext) {
        SlackMessage("PurchaseConfirmedChunkListener::END!!")
        super.afterChunk(context)
    }

    override fun afterChunkError(context: ChunkContext) {
        val slackMessage = SlackMessage(context.toString())
        slackMessage.setIcon(":bug:")
        slackMessage.setUsername("True.K")

        sendMessage(slackMessage)

        super.afterChunkError(context)

    }

    private fun sendMessage(message: SlackMessage) {
        val api = SlackApi(this.slackWebhookUrl)
        api.call(message)
    }
}