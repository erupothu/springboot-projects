package com.erupothu.kafka.service.core;

import com.erupothu.kafka.data.TaskStatus;

public interface KafkaProducerService {
    public void send(String topicName, String key, TaskStatus value);
}
