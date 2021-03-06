package com.study.amqp.service;

import com.study.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "study.news")
    public void receive(Book book) {
        System.out.println("收到mq消息：" + book);
    }

    @RabbitListener(queues = "study.news")
    public void receive01(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
