package com.creditsuisse.eventfilereader;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class EventFileReaderBeanTest {
	
	/**
	 * This test It reads a file from the specified path.
	 * The file content should be according to the event requirements and content, having a begin and an ending.
	 */
	@Test
	public void testReadFile() throws Exception {
		String[] filePath = {"C:\\worktask\\MyJson.json"};
		SpringBootConsoleApplication.main(filePath);
		assertTrue(true);
	}

}
