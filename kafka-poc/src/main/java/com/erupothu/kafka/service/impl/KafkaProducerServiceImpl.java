package com.erupothu.kafka.service.impl;

import com.erupothu.kafka.data.TaskStatus;
import com.erupothu.kafka.service.core.KafkaProducerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

  private final Logger LOGGER = LoggerFactory.getLogger(
    KafkaProducerServiceImpl.class
  );

  @Autowired
  KafkaTemplate<String, TaskStatus> kafkaTemplate;

  public void send(String topicName, String key, TaskStatus value) {
    var future = kafkaTemplate.send(topicName, key, value);

    future.whenComplete((sendResult, exception) -> {
      if (exception != null) {
        future.completeExceptionally(exception);
      } else {
        future.complete(sendResult);
      }
      LOGGER.info("Task status send to Kafka topic : " + value);
    });
  }
}
