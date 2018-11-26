package com.creditsuisse.eventfilereader.service;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditsuisse.eventfilereader.model.Event;


@Service
public class EventFileReaderBean implements EventFileReader {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private JsonParserEventBuilder eventBuilder;
	
	final static Logger logger = Logger.getLogger(EventFileReaderBean.class);
	
	private Map<String, Event> map = new ConcurrentHashMap<String, Event>();
	
	public void readFile(String path) throws Exception {
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
			logger.info("INFO - Begin reading file. "+path);
		    inputStream = new FileInputStream(path);
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        Event event = eventBuilder.parse(line);
		        handleEvent(event);
		    }
		    logger.info("INFO - End reading file. "+path);
		} catch(Exception ex){
			logger.error("ERROR -Failed to read file. "+ex);
		} finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
	}
	
	private void handleEvent(Event event) {
		String code = event.getIdevent();		
		if (!map.containsKey(code)) {
			map.put(code, event);
		} else {
			event = mergeEvents(map.remove(code), event);				
			eventService.save(event);	
			logger.info("INFO - Record saved. "+event);
		}
	}
	
	private Event mergeEvents(Event event1, Event event2) {
		long duration = Math.abs(event1.getDuration() - event2.getDuration());

		if (duration > 4) {
			event1.setAlert(true);
		}
		
		event1.setDuration(duration);
		return event1;
	}
	
}
