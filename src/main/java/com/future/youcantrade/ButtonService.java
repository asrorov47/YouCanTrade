package com.future.youcantrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
@Service
public class ButtonService {
    @Autowired
    private  ReplyMessageService replyMessageService;

    public ReplyKeyboardMarkup menu(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList();
        KeyboardRow first = new KeyboardRow();
        KeyboardRow second = new KeyboardRow();
        KeyboardButton buttonFirst = new KeyboardButton();
        KeyboardButton buttonSecond = new KeyboardButton();
        buttonFirst.setText(replyMessageService.getReplyText("button.savdo"));
        buttonSecond.setText(replyMessageService.getReplyText("button.tolov"));
        first.add(buttonFirst);
        second.add(buttonSecond);
        rowList.add(first);
        rowList.add(second);
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }
}
