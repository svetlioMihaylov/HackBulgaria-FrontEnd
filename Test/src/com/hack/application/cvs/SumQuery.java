package com.hack.application.cvs;

import java.util.List;

public class SumQuery implements MyQuery {

    private String query;

	public SumQuery(String text) {
	    this.query = text.toLowerCase();
	}

	@Override
	public void execute(Table table) {
	    String rows = query.substring(query.indexOf("sum")+ "sum".length()+1);
	List<String >  values = table.getData(rows);
	int sum=0;
	for(String s:values){
	    sum+=Integer.valueOf(s);
	}
	System.out.println(sum);
	}

}
