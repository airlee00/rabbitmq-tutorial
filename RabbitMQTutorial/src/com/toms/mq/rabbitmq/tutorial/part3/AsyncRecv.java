package com.toms.mq.rabbitmq.tutorial.part3;

import org.apache.log4j.Logger;

public class AsyncRecv {
	
   public Logger log = Logger.getLogger(AsyncRecv.class);
   private long t = System.currentTimeMillis();
   public void receive(String msg) {
	   log.debug(">>>>>>>>>" + msg+ "====" + (System.currentTimeMillis() - t));
	   //System.out.println(">>>>>>>>>"+msg);
   }
}
