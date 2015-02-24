package com.hack.application.cvs;

import java.util.ArrayList;
import java.util.List;

public class FindQuery implements MyQuery {
	private String query;
	public FindQuery(String text) {
	this.query=text.toLowerCase().trim();
	}

	@Override
	public void execute(Table table) {
		List<Integer> result = new ArrayList<Integer>();
	String what = query.substring("find".length()+1);
	List<String > columns = table.getAllColumns();
	  for(String s:columns){
		  List<String> column=table.getData(s);
		  for(String cell:column){
			  if(cell.contains(what)){
				  result.add(column.indexOf(cell));
			  }
		  }
	  }
	  for(String s:columns){
          System.out.print(s + "|");
	  }
	  System.out.println("");
	  for(Integer index:result){
		  System.out.println(table.getRowWithIndex(index));
	  }
	}

}
