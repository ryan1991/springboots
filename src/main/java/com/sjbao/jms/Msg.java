package com.sjbao.jms;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Author ryan.song
 * @Date 2018/10/18
 **/
public class Msg implements MessageCreator {

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("测试消息");
    }
}
