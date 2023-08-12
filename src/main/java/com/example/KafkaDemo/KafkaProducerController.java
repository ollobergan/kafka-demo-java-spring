package com.example.KafkaDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaProducerController {
    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/publish")
    public String messagePublisher(@RequestBody Book book){
        kafkaService.publish(book);
        return "Message successfully published!";
    }

    @PostMapping("/publish-with-key/{key}")
    public String messagePublisherWithKey(@RequestBody Book book,@PathVariable("key") String key){
        kafkaService.publish(book, key);
        return "Message successfully published!";
    }

    @PostMapping("/publish-with-key/{key}/partition/{partition}")
    public String messagePublisher(@RequestBody Book book,@PathVariable("key") String key, @PathVariable("partition") Integer partition){
        kafkaService.publish(book, key, partition);
        return "Message successfully published!";
    }

}
