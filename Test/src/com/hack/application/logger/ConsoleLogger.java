package com.hack.application.logger;

import java.util.Scanner;

public class ConsoleLogger extends AbstractLogger {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int level=scanner.nextInt();
	String messag=scanner.nextLine();
	scanner.close();
	Logger logger = new ConsoleLogger();
	System.out.println(logger.log(level, messag));
}
}
