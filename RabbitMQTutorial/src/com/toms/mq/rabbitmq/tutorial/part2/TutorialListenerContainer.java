package com.toms.mq.rabbitmq.tutorial.part2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class TutorialListenerContainer {
    public static void main(String[] args) {
        ApplicationContext c1 = new ClassPathXmlApplicationContext("classpath:context/part2/rabbit-listener-context.xml");
 
    }
}
