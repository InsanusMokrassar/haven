package org.havenapp.main.telegram

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.extensions.api.bot.getMe
import dev.inmo.tgbotapi.extensions.api.telegramBot
import io.ktor.client.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

/**
 * Created by Arka Prava Basu <arka@ultrahuman.com> on 1/27/22.
 **/
class PollingBotManager @JvmOverloads constructor(
    private val token: String,
    private val client: HttpClient = HttpClient(),
    workerDispatcher: CoroutineDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
) {
    private lateinit var bot: TelegramBot
    private val workerScope = CoroutineScope(workerDispatcher)

    init {
        workerScope.launch {
            setUp()
        }
    }

    private suspend fun setUp() {
        bot = telegramBot(token = token, client = client)
        println(bot.getMe())
    }
}
