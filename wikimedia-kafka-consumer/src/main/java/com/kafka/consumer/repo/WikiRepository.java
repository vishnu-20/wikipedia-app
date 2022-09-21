package com.kafka.consumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.consumer.entity.WikiData;

public interface WikiRepository extends JpaRepository<WikiData, Long>{

}
