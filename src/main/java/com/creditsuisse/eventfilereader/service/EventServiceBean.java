package com.creditsuisse.eventfilereader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditsuisse.eventfilereader.model.Event;
import com.creditsuisse.eventfilereader.repository.EventRepository;

@Service
public class EventServiceBean implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public void save(Event event) {
		eventRepository.save(event);		
	}
	
}
