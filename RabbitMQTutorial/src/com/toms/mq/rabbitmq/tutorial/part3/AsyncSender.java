package com.toms.mq.rabbitmq.tutorial.part3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class AsyncSender {

	public static void main(String[] args) throws InterruptedException {
		final AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:context/part3/rabbitmq-async-text-context.xml");
		MessageChannel channel = (MessageChannel) context.getBean("toRabbit");
		for (int i = 0; i < 1000; i++) {
			Message<String> msg = MessageBuilder.withPayload(
					"RabbitMQ async message test --" + i).build();
			channel.send(msg);
		}

		Thread.sleep(3000);
		context.close();
	}
}
