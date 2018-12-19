package com.sjbao.service;

import com.sjbao.annotation.MyService;

/**
 * @Author ryan.song
 * @Date 2018/12/19
 **/
@MyService("myAnnotationService")
public class MyAnnotationServiceImpl implements MyAnnotationService {
    @Override
    public void work(String name) {
        System.out.println(">>>>> "+ name + "do work");
    }
}
