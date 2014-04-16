package org.opencloudengine.samples.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.opencloudengine"})
@ImportResource(value = {"classpath:/applicationContext.xml"})
public class Application {

	@Autowired
	ProductService service;

	/**
	 * SLF4J Logging
	 */
	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication();
		application.getListeners().add(new ApplicationListener<ApplicationPreparedEvent>() {
			@Override
			public void onApplicationEvent(ApplicationPreparedEvent event) {
				ProductService service = event.getApplicationContext().getBean(ProductService.class);
				Product product = new Product();
				product.setName("Hello World");
				service.addProduct(product);
				logger.info("{}", product);
			}
		});
		application.run(Application.class, args);
	}

}