package com.hack.application.cvs;

public class QueryFactory {
	public static MyQuery buildQuery(String text){
		MyQuery query = null;
		text=text.trim();
		String type = text.substring(0, text.indexOf(" ")+1).toLowerCase();
		if(type.length()==0){
			type = text.toLowerCase().trim();
		}
		switch(type.toLowerCase().trim()){
		case "select": 
			query = new SelectQuery(text);
			break;
		case "sum" :
		query = new SumQuery(text);
		break;
		case "show" :
			query = new ShowQuery(text);
			break;
		case "find" :
			query = new FindQuery(text);
			break;
			
		}
		return query;
		
	}
}
