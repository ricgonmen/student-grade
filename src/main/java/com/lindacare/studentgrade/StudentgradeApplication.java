package com.lindacare.studentgrade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentgradeApplication {

	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(StudentgradeApplication.class);
		logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        
		SpringApplication.run(StudentgradeApplication.class, args);
	}
}
