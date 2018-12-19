package com.sjbao.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @Author ryan.song
 * @Date 2018/12/19
 **/
@Slf4j
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("application context hold...");
        ApplicationContextHolder.applicationContext = applicationContext;
    }

    public static <T> T getBean(String beanName, Class<T> clazz){
        return applicationContext.getBean(beanName, clazz);
    }

    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationClass){
        return applicationContext.getBeansWithAnnotation(annotationClass);

    }


}
