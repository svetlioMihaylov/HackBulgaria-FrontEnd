package com.hack.application.cvs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectQuery implements MyQuery {
	private String query;
	public SelectQuery(String text) {
		this.query = text.toLowerCase();
	}

	@Override
	public void execute(Table table) {
	
		List<String> columns;
		List<List<String>> result = new ArrayList<List<String>>();
		int lastIndexOfLimit=query.lastIndexOf("limit");
		boolean hasLimit =lastIndexOfLimit>0;
		if(hasLimit){
			String rows = query.substring(query.indexOf("select")+ "select".length()+1,query.lastIndexOf("limit"));
			columns = Arrays.asList(rows.split(","));
		} else {
			String rows = query.substring(query.indexOf("select")+ "select".length()+1,query.length());
			columns = Arrays.asList(rows.split(","));
		}
		for(String s:columns){
			
			List<String > tmp= new ArrayList<>(table.getData(s));
		//	Collections.copy(tmp, table.getData(s));
			if(hasLimit){
				int limit = Integer.valueOf(query.substring(query.lastIndexOf("limit")+"limit".length()+1));
				tmp=	tmp.subList(0, limit);
			}
			tmp.add(0, s);
			result.add(tmp);
		}
//		if(hasLimit){
//			int limit = Integer.valueOf(query.substring(query.lastIndexOf("limit")+"limit".length()+1));
//			while(result.get(0).size()>limit){
//				for(int i=0;i<result.size();i++){
//					result.get(i).remove(limit);
//				}
//				result.remove(limit);
//			}
//		}
//	
		for(List<String > row:result){
		    for(String content:row){
		        System.out.println(content);
		    }
		}
		
	}

	}
