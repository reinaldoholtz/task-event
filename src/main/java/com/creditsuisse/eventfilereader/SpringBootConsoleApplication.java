package com.creditsuisse.eventfilereader;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.creditsuisse.eventfilereader.service.EventFileReader;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
	
	final static Logger logger = Logger.getLogger(SpringBootConsoleApplication.class);

    @Autowired
	private EventFileReader eventFileReader;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
        	logger.info("INFO - Begin of execution.");
        	eventFileReader.readFile(args[0]);
        	logger.info("INFO - Execution completed.");
        }else {
        	logger.info("INFO - File Not Received...");
        }
    }
   
}
