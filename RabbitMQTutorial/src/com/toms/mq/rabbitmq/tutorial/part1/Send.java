package com.toms.mq.rabbitmq.tutorial.part1;

import java.util.Date;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 * http://www.rabbitmq.com/tutorials/tutorial-one-java.html
 * 
 *
 */
public class Send {
	
  private final static String QUEUE_NAME = "hello";

  public static void main(String[] argv) throws Exception {
      	      
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    for(int i=0;i<100;i++) {
    	String message = "Hello World!" + new Date();
    	channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
    	System.out.println(" [x] Sent '" + message + "'");
    	Thread.sleep(3000);
    }
    channel.close();
    connection.close();
  }
}