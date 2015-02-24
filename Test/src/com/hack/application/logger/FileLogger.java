package com.hack.application.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileLogger extends AbstractLogger {
	private Path path;
	public FileLogger(Path path){
		this.path = path;
	}
	public void logMsg(String message,int level){
		try {
			Files.write(path, super.log(level, message).getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
