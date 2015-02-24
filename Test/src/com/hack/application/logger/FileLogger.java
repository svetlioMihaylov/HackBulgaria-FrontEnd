package com.hack.application.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileLogger {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int level=scanner.nextInt();
		Path path = Paths.get("");
		String messag=scanner.nextLine();
		scanner.close();
		Logger logger = new ConsoleLogger();
		Files.write(path, logger.log(level, messag).getBytes());
	
}
}
