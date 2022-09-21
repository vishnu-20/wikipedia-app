package com.kafka.producer.handler;

import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KafkaChangeHandler implements EventHandler {

	KafkaTemplate<String, String> kafkaTemplate;
	String topicName;

	public KafkaChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topicName) {
		super();
		this.kafkaTemplate = kafkaTemplate;
		this.topicName = topicName;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		log.info("----- data ---- {}", messageEvent.getData());
		kafkaTemplate.send(topicName, messageEvent.getData());
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub

	}

}
