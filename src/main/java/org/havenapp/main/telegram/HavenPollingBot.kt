//package org.havenapp.main.telegram
//
//import org.telegram.telegrambots.bots.TelegramLongPollingBot
//import org.telegram.telegrambots.meta.TelegramBotsApi
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage
//import org.telegram.telegrambots.meta.api.objects.Update
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException
//import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
//
//
///**
// * Created by Arka Prava Basu <arka@ultrahuman.com> on 1/26/22.
// **/
//class HavenPollingBot : TelegramLongPollingBot() {
//    override fun getBotToken(): String = TOKEN
//
//    override fun getBotUsername(): String = BOT_USERNAME
//
//    override fun onUpdateReceived(update: Update?) {
//        if (update?.hasMessage() == true && update.message.hasText()) {
//            val message = SendMessage() // Create a SendMessage object with mandatory fields
//            message.chatId = update.message.chatId.toString() // todo should probably save this chat id
//            message.text = update.message.text
//            try {
//                execute(message) // Call method to send the message
//            } catch (e: TelegramApiException) {
//                e.printStackTrace()
//            }
//        }
//    }
//}
//
//fun HavenPollingBot.setUpBot() {
//    try {
//        val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
//        telegramBotsApi.registerBot(this)
//    } catch (e: TelegramApiException) {
//        e.printStackTrace()
//    }
//}
