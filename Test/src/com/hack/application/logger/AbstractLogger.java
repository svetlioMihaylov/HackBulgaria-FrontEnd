package com.hack.application.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class AbstractLogger implements Logger {
	@Override
	public String log(int level, String text) {
		 TimeZone tz = TimeZone.getTimeZone("UTC");
		    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		    df.setTimeZone(tz);
		    String nowAsISO = df.format(new Date());	
		 String logmsg=getLevel(level) + "::"  + nowAsISO + "::" + text;
		return logmsg; 
		
		
	}

	private String getLevel(int level) {
		switch(level){
		case 1 : return "INFO ";
		case 2 : return "WARNING ";
		case 3 : return "PLSCHECKFFS ";
		default : return "UNSUPPORTED LEVEL";
		
			
		}
	}



}
