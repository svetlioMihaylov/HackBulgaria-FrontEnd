package com.hack.application.logger;


public class ConsoleLogger extends AbstractLogger {
	public void logMsg(String mesage,int lvl){
		System.out.println(super.log(lvl, mesage));
	}

}
