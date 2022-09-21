package com.kafka.producer.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.producer.handler.KafkaChangeHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikiKafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void publishWikiMessages() {
		String topicName = "wikimedia-topic";
		// read real time data we use event source

		EventHandler eventHandler = new KafkaChangeHandler(kafkaTemplate, topicName);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";

		EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(url)).build();
		eventSource.start();

		try {
			TimeUnit.MINUTES.sleep(10);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
