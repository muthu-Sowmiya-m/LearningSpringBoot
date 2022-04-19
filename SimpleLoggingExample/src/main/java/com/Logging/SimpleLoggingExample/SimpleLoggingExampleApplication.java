package com.Logging.SimpleLoggingExample;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@CommonsLog @Slf4j etc., can also be used
These are provided by Lombok dependency by which logger class need not be instantiated
 */
@Log4j2
@SpringBootApplication
public class SimpleLoggingExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleLoggingExampleApplication.class, args);
		log.trace("Accessed Main method()");
		log.info("Application Running");

	}

}
