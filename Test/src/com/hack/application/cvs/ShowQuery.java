package com.hack.application.cvs;

import java.util.List;

public class ShowQuery implements MyQuery {
    private String query ;
	public ShowQuery(String text) {
		this.query=text.toLowerCase();
	}

	@Override
	public void execute(Table table) {
		List<String > columns = table.getAllColumns();
		  for(String s:columns){
	            System.out.print(s+ "|");

	}

}
}