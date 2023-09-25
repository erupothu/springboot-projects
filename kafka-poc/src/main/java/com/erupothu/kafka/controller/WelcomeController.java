package com.erupothu.kafka.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erupothu.kafka.data.Message;
import com.erupothu.kafka.data.TaskStatus;
import com.erupothu.kafka.data.TaskStatus.Status;
import com.erupothu.kafka.service.core.KafkaProducerService;

@RestController
@RequestMapping("api/kafka")
public class WelcomeController {

    @Autowired
    KafkaProducerService kafkaProducerService;
    
    @GetMapping("welcome")
    public ResponseEntity<?> welcome() {

        return new ResponseEntity<>("welcome to Kafka Application", HttpStatus.OK);
    }

    @PostMapping("message")
    public ResponseEntity<?> sendMessage(@RequestBody Message  msg) {
        kafkaProducerService.send(msg.getTopicName(), msg.getKey(), new TaskStatus(msg.getKey(), "kafka basic topics", 50.0f, Status.RUNNING));
        kafkaProducerService.send(msg.getTopicName(), msg.getKey(), new TaskStatus(msg.getKey(), "kafka basic topics", 100.0f, Status.FINISHED));
        return ResponseEntity.ok().body("message sent successfully");
    }
}
