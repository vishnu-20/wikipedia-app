package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.producer.service.WikiKafkaProducer;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

	@Autowired
	private WikiKafkaProducer kafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		kafkaProducer.publishWikiMessages();

	}

}
