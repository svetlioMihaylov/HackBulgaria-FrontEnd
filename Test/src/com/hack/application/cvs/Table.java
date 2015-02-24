package com.hack.application.cvs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
	private Map<String,List<String>> table;
	private QueryExecutor executor;
	public Table(List<String> columns){
		table = new HashMap<String, List<String>>();
		for(String column:columns){
			table.put(column, new ArrayList<String>());
		}
	}
	public void setData(String column,String data){
		table.get(column).add(data);
	}
	public List<String> getData(String column){
		return table.get(column.trim());
	}
	public void executeQuery(MyQuery query){
		 executor.execute(this,query);
	}
	public List<String> getAllColumns (){
	  return  new ArrayList<>(table.keySet());
	}
	public String getRowWithIndex(Integer index) {
		StringBuilder builder = new StringBuilder();
		for(String column:table.keySet()){
			builder.append(table.get(column).get(index)).append("|");
		}
		return builder.toString();
	}
	
}
