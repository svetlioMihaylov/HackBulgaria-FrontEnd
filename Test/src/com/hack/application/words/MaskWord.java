package com.hack.application.words;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaskWord {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String words = scanner.nextLine();
	String test = scanner.nextLine();
	String result = maskWords(words,test);
	System.out.println(result);
	scanner.close();
}

private static String maskWords(String word, String test) {
	List<String > words = Arrays.asList(word.split(","));
	for(String s : words){
		test = test.replace(s, "****");
	}
	return test;
}
}
