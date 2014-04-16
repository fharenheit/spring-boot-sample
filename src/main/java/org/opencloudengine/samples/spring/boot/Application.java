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
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		ProductService service = ctx.getBean(ProductService.class);
		Product product = new Product();
		product.setName("Hello World");
		service.addProduct(product);
		logger.info("{}", product);
	}

}