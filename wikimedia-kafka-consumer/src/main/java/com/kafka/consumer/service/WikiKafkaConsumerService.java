package com.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.entity.WikiData;
import com.kafka.consumer.repo.WikiRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WikiKafkaConsumerService {

	@Autowired
	private WikiRepository wikiRepository;

	@KafkaListener(topics = "wikimedia-topic", groupId = "myGroup")
	public void getAllDataPublished(String eventMessage) {

		log.info("--------consume-----{}", eventMessage);

	WikiData data=	wikiRepository.save(WikiData.builder().eventMessage(eventMessage).build());
	System.out.println("hi");
	}

}
