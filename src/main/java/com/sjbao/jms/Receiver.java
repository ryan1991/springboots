package com.sjbao.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author ryan.song
 * @Date 2018/10/18
 **/
@Component
public class Receiver  {
    @JmsListener(destination = "myDestination")
    public void receiveMessage(String message){
        System.out.println(">>>接受到："+ message);

    }

}
