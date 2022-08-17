package com.future.youcantrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class StartBot extends TelegramLongPollingBot {

    @Autowired
    private ReplyMessageService replyMessageService;
    @Autowired
    private ButtonService buttonService;

    @Override
    public String getBotUsername() {
        return "youcantrade_bot";
    }

    @Override
    public String getBotToken() {
        return "5541241347:AAFILz3q3rMeccKRmbnU1JEUG952TaH2B78";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String text = message.getText();
        SendMessage sendMessage = new SendMessage();
        if (message.hasText()) {
            if (text.equals("/start")) {
                sendMessage.setText(replyMessageService.getReplyText("message.salom"));
                sendMessage.setChatId(String.valueOf(message.getChatId()));
                sendMessage.setReplyMarkup(buttonService.menu());
                executeMessage(sendMessage);
            }else if (text.equals(replyMessageService.getReplyText("button.savdo"))){
                sendMessage.setChatId(String.valueOf(message.getChatId()));
                sendMessage.setText(replyMessageService.getReplyText("message.shart1") );
                executeMessage(sendMessage);

                sendMessage.setChatId(String.valueOf(message.getChatId()));
                sendMessage.setText(replyMessageService.getReplyText("message.shart2"));
                executeMessage(sendMessage);

                sendMessage.setChatId(String.valueOf(message.getChatId()));
                sendMessage.setText(replyMessageService.getReplyText("message.shart3"));
                executeMessage(sendMessage);


            }else if (text.equals(replyMessageService.getReplyText("button.tolov"))){
               sendMessage.setChatId(String.valueOf(message.getChatId()));
               sendMessage.setText(replyMessageService.getReplyText("message.shart4"));
               executeMessage(sendMessage);

               sendMessage.setChatId(String.valueOf(message.getChatId()));
               sendMessage.setText(replyMessageService.getReplyText("message.shart5"));
               executeMessage(sendMessage);

               sendMessage.setChatId(String.valueOf(message.getChatId()));
               sendMessage.setText(replyMessageService.getReplyText("message.shart6"));
               executeMessage(sendMessage);

               sendMessage.setChatId(String.valueOf(message.getChatId()));
               sendMessage.setText(replyMessageService.getReplyText("message.shart7"));
               executeMessage(sendMessage);

            }
        }
    }

    private void executeMessage(SendMessage sendMessage){
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
