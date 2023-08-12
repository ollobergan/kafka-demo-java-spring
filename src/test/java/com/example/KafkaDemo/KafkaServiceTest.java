package com.example.KafkaDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@Import(KafkaConfig.class)
@TestPropertySource(locations="classpath:test.properties")
public class KafkaServiceTest {

    @Autowired
    private KafkaService kafkaService;

    @Test
    void simepleMessagePublish(){

        Book book = new Boo k();
        book.setBookName("Book 1");
        book.setIsbn("isbn");

        kafkaService.publish(book);
    }

    @Test
    void MessagePublishWithKey(){
        String key = "Key1";
        Book book = new Book();
        book.setBookName("Book 1");
        book.setIsbn("isbn");

        kafkaService.publish(book, key);
    }

    @Test
    void MessagePublishWithKeyPartition(){
        String key = "Key1";
        Integer partition = 0;
        Book book = new Book();
        book.setBookName("Book 1");
        book.setIsbn("isbn");

        kafkaService.publish(book, key, partition);
    }
}
