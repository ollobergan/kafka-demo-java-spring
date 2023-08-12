package com.example.KafkaDemo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topicPartitions = @TopicPartition(topic = "newBooksPartition",partitions = {"0","1","4"}), groupId = "book-group-id", containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload  Book book, @Header(KafkaHeaders.RECEIVED_KEY) String key, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println("PARTITION="+partition+", key="+key+" => "+book.toString());
    }

    @KafkaHandler(isDefault = true)
    void listenDefault(Object object) {
        System.out.println(object.toString());
    }
}
