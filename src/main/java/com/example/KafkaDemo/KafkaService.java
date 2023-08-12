package com.example.KafkaDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    KafkaTemplate<String,Book> kafkaTemplate;

    private static final String TOPIC = "newBooksPartition";

    /**
     * Publish message without key and partition
     * @param book
     */
    public void publish(Book book){
        kafkaTemplate.send(TOPIC, book);
    }

    /**
     * Publish messagae with key
     * @param book
     * @param key
     */
    public void publish(Book book, String key){
        kafkaTemplate.send(TOPIC, key, book);
    }

    /**
     * Publish event with key to specific partition
     * @param book
     * @param key
     * @param partition
     */
    public void publish(Book book, String key, Integer partition){
        kafkaTemplate.send(TOPIC, partition, key, book);
    }

}
