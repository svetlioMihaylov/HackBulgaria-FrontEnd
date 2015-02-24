package com.hack.application.tests;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hack.application.logger.ConsoleLogger;

public class ConsoleLoggerTest {
	private ConsoleLogger logger;
	@Before
	public void setUp() throws Exception {
		logger = new ConsoleLogger();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String expected = logger.log(1, "msglvl1");
		logger.logMsg("msglvl1", 1);
		Scanner scanner = new Scanner (System.in);
		String actual = scanner .nextLine();
//		assertEquals(expected,actual);
	}

}
