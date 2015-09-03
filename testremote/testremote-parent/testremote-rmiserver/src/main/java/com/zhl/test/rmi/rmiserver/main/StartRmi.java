package com.zhl.test.rmi.rmiserver.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartRmi {
	static Logger logger = LoggerFactory.getLogger(StartRmi.class);
	
	public static void main(String[] args) {
		 try{ 
			 ApplicationContext ctx = new ClassPathXmlApplicationContext(  
	                "applicationContext.xml");  
			 System.out.println("RMI服务伴随Spring的启动而启动了.....");
		
			 Object lock = new Object();  
			 synchronized (lock) {  
	            lock.wait();
			 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}

}
