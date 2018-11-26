package com.creditsuisse.eventfilereader.service;

public interface EventFileReader {
	
	/**
	 * It reads a file from the specified path, streaming its content avoid large memory consumption.
	 * The file content should be according to the event requirements and content, having a begin and an ending.
	 * 
	 * @param path 
	 */
	void readFile(String path) throws Exception;

}
