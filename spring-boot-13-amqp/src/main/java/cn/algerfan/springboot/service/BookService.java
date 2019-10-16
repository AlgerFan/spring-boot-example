package cn.algerfan.springboot.service;

import cn.algerfan.springboot.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BookService {

    @RabbitListener(queues = "mq.news")
    public void receive(Book book){
        System.out.println("收到消息："+book);
    }

    /**
     * 获取body和messageProperties的信息
     * @param message
     */
    @RabbitListener(queues = "mq")
    public void receive02(Message message){
        System.out.println(Arrays.toString(message.getBody()));
        System.out.println(message.getMessageProperties());
    }

}

