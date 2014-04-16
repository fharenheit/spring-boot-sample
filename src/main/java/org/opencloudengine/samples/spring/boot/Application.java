package org.opencloudengine.samples.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.opencloudengine"})
@ImportResource(value = {"classpath:/applicationContext.xml"})
public class Application {

	/**
	 * SLF4J Logging
	 */
	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		System.out.println("  _____ _                 _                     ____        _       _       _                           _               \n" +
			" |  ___| | __ _ _ __ ___ (_)_ __   __ _  ___   | __ )  __ _| |_ ___| |__   | |    __ _ _   _ _ __   ___| |__   ___ _ __ \n" +
			" | |_  | |/ _` | '_ ` _ \\| | '_ \\ / _` |/ _ \\  |  _ \\ / _` | __/ __| '_ \\  | |   / _` | | | | '_ \\ / __| '_ \\ / _ \\ '__|\n" +
			" |  _| | | (_| | | | | | | | | | | (_| | (_) | | |_) | (_| | || (__| | | | | |__| (_| | |_| | | | | (__| | | |  __/ |   \n" +
			" |_|   |_|\\__,_|_| |_| |_|_|_| |_|\\__, |\\___/  |____/ \\__,_|\\__\\___|_| |_| |_____\\__,_|\\__,_|_| |_|\\___|_| |_|\\___|_|   \n" +
			"                                  |___/                                                                                 \n");

		SpringApplication app = new SpringApplication(Application.class);
		app.setShowBanner(false);
		ApplicationContext ctx = app.run(args);

		ProductService service = ctx.getBean(ProductService.class);
		Product product = new Product();
		product.setName("Hello World");
		service.addProduct(product);
		logger.info("{}", product);
	}

}