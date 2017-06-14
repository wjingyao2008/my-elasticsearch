package yang.yang.elastic.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.support.AbstractElasticsearchRepository;
import yang.yang.elastic.demo.model.Car;
import yang.yang.elastic.demo.service.CarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	CarService carService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		carService.findAll().forEach(it->LOGGER.info(it.toString()));
		LOGGER.info("done");
	}
}
