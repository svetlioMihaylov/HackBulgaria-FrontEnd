package com.hack.application.cvs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CVSParser {
public static Table parseFile(Path path) throws IOException{
	List<String> fileContent = Files.readAllLines(path, Charset.defaultCharset());
	List<String > columns = Arrays.asList(fileContent.remove(0).split(","));
	
	List<String> list = new LinkedList<String>(columns);
	for(int i=0;i<list.size();i++){
	    String tmp = list.remove(i);
	    tmp=tmp.trim();
	    list.add(i, tmp);
	}
	Table table = new Table(list);
	for(String line:fileContent){
		List<String > separetedInfo = Arrays.asList(line.split(","));
		for(int i=0;i<separetedInfo.size();i++){
			String columnName= columns.get(i);
			String data = separetedInfo.get(i);
			table.setData(columnName, data);
		}
	}
	return table;
	
}
}
