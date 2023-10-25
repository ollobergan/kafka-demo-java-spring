package com.example.KafkaDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService22 {
    @Autowired
    KafkaTemplate<String,KafkaTest> kafkaTemplate;

    private static final String TOPIC = "clickhousetopic";

    /**
     * Publish message without key and partition
     * @param obj
     */
    public void publish(KafkaTest obj){
        kafkaTemplate.send(TOPIC, obj);
    }


}
