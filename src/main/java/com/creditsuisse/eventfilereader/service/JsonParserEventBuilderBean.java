package com.creditsuisse.eventfilereader.service;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.creditsuisse.eventfilereader.model.Event;

@Service
public class JsonParserEventBuilderBean implements JsonParserEventBuilder {

	final static Logger logger = Logger.getLogger(EventFileReaderBean.class);
	
	@Override
	public Event parse(String strLine) {
		JSONParser jparser = new JSONParser();	
		try {
			logger.info("INFO - Begin parse of line "+strLine);
			Object obj = jparser.parse(strLine);
			JSONObject jsonObj = (JSONObject)obj;
			String idEvent   = (String) jsonObj.get("id");
			Long timestamp   = (Long) jsonObj.get("timestamp");
			String eventtype = (String) jsonObj.get("type");
			String host      = (String) jsonObj.get("host");
			
			Event event = new Event();
			event.setIdevent(idEvent);
			event.setEventtype(eventtype);
			event.setHost(host);
			event.setDuration(Long.valueOf(timestamp));
			return event;
		} catch(ParseException pe) {
			logger.error("ERROR - Failed to parse file contents in line "+strLine+". "+pe);
		}
		return null;
	}
	
}
