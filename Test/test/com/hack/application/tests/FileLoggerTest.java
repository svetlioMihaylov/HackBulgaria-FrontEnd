package com.hack.application.tests;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hack.application.logger.FileLogger;

public class FileLoggerTest {
	
	private FileLogger logger ;
	Path path = Paths.get("D:\\junk\\testLogger.txt");
	@Before
	public void setUp() throws Exception {
		if(!path.toFile().exists()){
			Files.createFile(path);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		logger = new FileLogger(path);
		logger.logMsg("lvl1msg", 1);
		String expected  = logger.log(1,"lvl1msg");
		List<String> fileContent;
		try {
			fileContent = Files.readAllLines(path, Charset.defaultCharset());
			Assert.assertEquals(fileContent.get(0), expected);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
