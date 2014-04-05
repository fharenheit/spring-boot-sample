package org.opencloudengine.samples.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource(value = {"classpath:/applicationContext.xml"})
public class Application {

    /**
     * SLF4J Logging
     */
    private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

        logger.info("Hello World");
	}

}