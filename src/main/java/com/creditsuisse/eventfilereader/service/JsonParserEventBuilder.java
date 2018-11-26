package com.creditsuisse.eventfilereader.service;

import com.creditsuisse.eventfilereader.model.Event;

public interface JsonParserEventBuilder {
	/**
	 * It makes the parse from Json content file
	 * 
	 * @param strLine
	 */
	Event parse(String strLine);

}
