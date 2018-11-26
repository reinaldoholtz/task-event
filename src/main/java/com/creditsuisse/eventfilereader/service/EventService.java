package com.creditsuisse.eventfilereader.service;

import com.creditsuisse.eventfilereader.model.Event;

public interface EventService {
	
	/**
	 * It saves the event in the Event table
	 * 
	 * @param event 
	 */
	void save(Event event);
	
}
